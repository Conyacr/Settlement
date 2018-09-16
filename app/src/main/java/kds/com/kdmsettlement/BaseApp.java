package kds.com.kdmsettlement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import kds.com.kdmsettlement.dependencies.DaggerDependencies;
import kds.com.kdmsettlement.dependencies.Dependencies;
import kds.com.kdmsettlement.networking.NetworkModule;

/**
 * Created by Ryan on 8/3/2018.
 */

public class BaseApp  extends AppCompatActivity {
    Dependencies dependencies;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        dependencies = DaggerDependencies.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Dependencies getDependencies() {
        return dependencies;
    }
}
