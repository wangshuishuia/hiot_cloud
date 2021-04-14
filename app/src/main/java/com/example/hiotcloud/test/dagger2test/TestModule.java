package com.example.hiotcloud.test.dagger2test;

import dagger.Module;
import dagger.Provides;

/**
 * dagger2测试Module类
 */
@Module
public class TestModule {
    @Provides
    public ThirdObj getThirdObj(){
        return new ThirdObj();
    }
}
