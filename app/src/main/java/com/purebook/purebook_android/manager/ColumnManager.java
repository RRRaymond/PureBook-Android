package com.purebook.purebook_android.manager;

import com.purebook.purebook_android.base.BaseColumnFragment;
import com.purebook.purebook_android.bean.BookColumn;
import com.purebook.purebook_android.constants.Constants;
import com.purebook.purebook_android.fragment.BookListFragment;
import com.purebook.purebook_android.fragment.TagListFragment;

/**
 * Created by chrischen on 2018/1/13.
 */

public class ColumnManager {
    public static BaseColumnFragment getColumnFragment(BookColumn bookColumn) {
        switch (bookColumn.getType()) {
            case Constants.TYPE_COLUMN_BOOK:
                return BookListFragment.newInstance(bookColumn);
            case Constants.TYPE_COLUMN_TAG:
                return TagListFragment.newInstance(bookColumn);
            case Constants.TYPE_COLUMN_Random:
                return RandomFragment.newInstance(bookColumn);
            case Constants.TYPE_COLUMN_NEARMAP:
                return NearMapFragment.newInstance(bookColumn);
        }
        return BookListFragment.newInstance(bookColumn);
    }
}
