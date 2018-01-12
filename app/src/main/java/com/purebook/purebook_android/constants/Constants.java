package com.purebook.purebook_android.constants;

import android.graphics.Bitmap;

/**
 * Created by chrischen on 2017/12/26.
 */

public class Constants {

    public static final long DELAY_NETWORK = 500;
    public static final int CLOUD_MAIN_COLUMN_MAX_ORDER = 10;
    public static final long DAY_AGE = 24 * 60 * 60 * 1000;
    public static final int PAGE_COUNT = 20;
    public static final long ANIM_DURATION_LONG = 900;
    public static final long ANIM_DURATION_MIND = 400;
    public static final long ANIM_DURATION_SHORT = 200;
    public static final int TYPE_COLUMN_BOOK = 1;
    public static final int TYPE_COLUMN_TAG = 2;
    public static final int TYPE_COLUMN_Random = 3;
    public static final int TYPE_COLUMN_NEARMAP = 4;
    public static final long LAZY_DELAY_TIME = 100;
    public static final int BLUE_VALUE = 30;
    public static final int[] TYPE_HIDE_FAB = {TYPE_COLUMN_Random, TYPE_COLUMN_NEARMAP};//不需要fab的type
    public static final String THEME_NIGHT = "night";
    public static final String EVENT_THEME_CHANGE = "event_themt_change";
    public static final String RES_COLOR_STATUSBAR = "statusbar_background";
    public static final String RES_COLOR_LOAD_PROGRESS = "load_background";
    public static final String RES_COLOR_TEXT = "text_color";
    public static final String RES_COLOR_TEXT_HIGHT = "text_color_hight";
    public static final String RES_COLOR_TEXT_BACKGROUND = "text_background";
    public static final String RES_COLOR_WINDOWS = "window_background";
    public static final int NEAR_FRIEND_SIZE = 10;
    public static final int TRY_LOCAL_COUNT=3;//定位失败重试3次

    /*public static DisplayImageOptions getImageOptions() {
        if (options != null) {
            return options;
        }
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.NONE)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
                .displayer(new FadeInBitmapDisplayer(1000))//是否图片加载好后渐入的动画时间
                .build();//构建完成
        return options;
    }*/
}
