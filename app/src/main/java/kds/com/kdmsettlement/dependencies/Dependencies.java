package kds.com.kdmsettlement.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import kds.com.kdmsettlement.home.HomeActivity;
import kds.com.kdmsettlement.networking.NetworkModule;

/**
 * Created by Ryan on 8/3/2018.
 */

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Dependencies {
    void inject(HomeActivity homeActivity);
}
