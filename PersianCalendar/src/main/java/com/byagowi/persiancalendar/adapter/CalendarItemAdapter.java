package com.byagowi.persiancalendar.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.byagowi.persiancalendar.R;
import com.byagowi.persiancalendar.calendar.AbstractDate;
import com.byagowi.persiancalendar.databinding.CalendarItemBinding;
import com.byagowi.persiancalendar.util.CalendarType;
import com.byagowi.persiancalendar.util.CalendarUtils;
import com.byagowi.persiancalendar.util.TypefaceUtils;
import com.byagowi.persiancalendar.util.Utils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarItemAdapter extends RecyclerView.Adapter<CalendarItemAdapter.ViewHolder> {
    private final Typeface mCalendarFont;
    private List<CalendarType> mCalendars = new ArrayList<>();
    private boolean mExpanded = false;
    private long mJdn;

    public CalendarItemAdapter(Context context) {
        mCalendarFont = TypefaceUtils.getCalendarFragmentFont(context);
    }

    public void setDate(List<CalendarType> calendars, long jdn) {
        mCalendars = calendars;
        mJdn = jdn;
        for (int i = 0; i < mCalendars.size(); ++i) notifyItemChanged(i);
//        notifyDataSetChanged();
    }

    public boolean isExpanded() {
        return mExpanded;
    }

    public void setExpanded(boolean expanded) {
        this.mExpanded = expanded;
        for (int i = 0; i < mCalendars.size(); ++i) notifyItemChanged(i);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CalendarItemBinding binding = CalendarItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mCalendars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CalendarItemBinding binding;

        ViewHolder(CalendarItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            boolean applyLineMultiplier = !TypefaceUtils.isCustomFontEnabled();
            binding.linear.setVisibility(View.GONE);

            binding.monthYear.setTypeface(mCalendarFont);
            binding.day.setTypeface(mCalendarFont);
            if (applyLineMultiplier) binding.monthYear.setLineSpacing(0, .6f);

            binding.container.setOnClickListener(this);
            binding.linear.setOnClickListener(this);
        }

        public void bind(int position) {
            AbstractDate date = CalendarUtils.getDateFromJdnOfCalendar(mCalendars.get(position), mJdn);

            binding.linear.setVisibility(mExpanded ? View.VISIBLE : View.GONE);
            binding.linear.setText(CalendarUtils.toLinearDate(date));
            String firstCalendarString = CalendarUtils.formatDate(date);
            binding.container.setContentDescription(firstCalendarString);
            binding.day.setContentDescription("");
            binding.day.setText(Utils.formatNumber(date.getDayOfMonth()));
            binding.monthYear.setContentDescription("");
            binding.monthYear.setText(String.format("%s\n%s",
                    CalendarUtils.getMonthName(date),
                    Utils.formatNumber(date.getYear())));
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            ClipboardManager clipboardService =
                    (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            CharSequence text = view.getContentDescription();

            if (clipboardService != null && text != null) {
                clipboardService.setPrimaryClip(ClipData.newPlainText("converted date", text));
                Toast.makeText(context, "«" + text + "»\n" + context.getString(R.string.date_copied_clipboard), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
