package global.sud.gi.white.demo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import global.sud.gi.white.api.SUDGIWhite;
import global.sud.gi.white.api.callback.SUDGIWhiteCallback;
import global.sud.gi.white.api.model.SUDGIWhiteError;

/** 入口等待 White 初始化，页面及业务流程由 White 提供。 */
public final class SUDWhiteDemoApplication extends Application {
    private static final String TAG = "SUDWhiteDemo";

    @Override
    public void onCreate() {
        super.onCreate();
        SUDGIWhite.initialize(this, BuildConfig.SUD_WHITE_DEMO_APP_ID, BuildConfig.SUD_WHITE_DEMO_APP_KEY,
            new SUDGIWhiteCallback<Void>() {
                @Override
                public void onSuccess(@Nullable Void value) {
                    Log.i(TAG, "White initialized");
                }

                @Override
                public void onFailure(@NonNull SUDGIWhiteError error) {
                    Log.e(TAG, "White initialization failed: " + error.getCode());
                }
            });
    }
}
