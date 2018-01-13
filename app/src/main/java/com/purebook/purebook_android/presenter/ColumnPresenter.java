package com.purebook.purebook_android.presenter;

import com.purebook.purebook_android.base.BaseRxPresenter;
import com.purebook.purebook_android.bean.BookColumn;
import com.purebook.purebook_android.view.ColumnView;

import java.util.List;

/**
 * Created by chrischen on 2018/1/13.
 */

public abstract class ColumnPresenter extends BaseRxPresenter<ColumnView,List<BookColumn>> {
    abstract public void getColumnData(BookColumn parentBookColumn,boolean pullToRefresh);
}
