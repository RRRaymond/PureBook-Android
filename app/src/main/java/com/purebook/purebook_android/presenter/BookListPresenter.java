package com.purebook.purebook_android.presenter;

import com.purebook.purebook_android.base.BaseRxPresenter;
import com.purebook.purebook_android.bean.Book;
import com.purebook.purebook_android.bean.BookColumn;
import com.purebook.purebook_android.view.BookListView;

import java.util.List;

/**
 * Created by chrischen on 2018/1/13.
 */

public class BookListPresenter extends BaseRxPresenter<BookListView,List<Book>> {
    abstract public void getBookData(BookColumn bookColumn, boolean pullToRefresh, int skip, int limit);
}
