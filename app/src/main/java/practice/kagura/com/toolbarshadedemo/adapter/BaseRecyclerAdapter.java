package practice.kagura.com.toolbarshadedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Rev$
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<T> datas = new ArrayList<T>();

    private View.OnClickListener onClickListener ;

    public BaseRecyclerAdapter(Context context) {
        super();
        this.mContext = context;
        this.datas = new ArrayList<T>();
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public BaseRecyclerAdapter(Context context, List<T> datas) {
        super();
        this.mContext = context;
        this.datas.addAll(datas);
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 加载数据
     *
     * @param datas
     */
    public void setData(List<T> datas) {
        if (null != datas) {
            this.datas = datas;
            notifyDataSetChanged();
        }
    }

    public List<T> getData() {
        return this.datas;
    }

    public T getOneData(int potion) {
        return datas.get(potion);
    }

    /**
     * 上拉加载数据
     *
     * @param datas
     */
    public void addData(List<T> datas) {
        if (null != datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    /**
     * 清除数据源
     */
    public void clearData() {
        if (datas != null) {
            datas.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(setConvertView(), parent, false);
        return setViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder((BaseViewHolder)holder, position);
    }

    public abstract int setConvertView();

    public abstract RecyclerView.ViewHolder setViewHolder(View view);

    public abstract void onBindViewHolder(BaseViewHolder holder, int position);


    public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        protected View root;
        public BaseViewHolder(View convertView) {
            super(convertView);
            this.root = convertView;
        }

        public abstract void onBind(T data,int position);
    }
}

