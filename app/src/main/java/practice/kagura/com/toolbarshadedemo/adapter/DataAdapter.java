package practice.kagura.com.toolbarshadedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import practice.kagura.com.toolbarshadedemo.R;

/**
 * @version $Rev$
 * @auther yinfengma
 * @time 2018/9/30.上午11:23
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateData $Author$
 * @updatedes ${TODO}
 */

public class DataAdapter extends BaseRecyclerAdapter<String> {

    public DataAdapter(Context context) {
        super(context);
    }

    @Override
    public int setConvertView() {
        return R.layout.item;
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(View view) {
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(datas.get(position),position);
    }

    public class DataViewHolder extends BaseViewHolder<String>{
        private View root;
        public DataViewHolder(View convertView) {
            super(convertView);
            root = convertView;
        }

        @Override
        public void onBind(String data, int position) {
            TextView tvData = root.findViewById(R.id.tv_data);
            tvData.setText(data);
        }
    }
}
