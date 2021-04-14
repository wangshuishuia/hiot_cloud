package com.example.hiotcloud.test.dagger2test;

import com.example.hiotcloud.test.mvptest.TestMVPActivity;

import dagger.Component;

/**
 * 测试注入器接口
 */
@Component(modules = TestModule.class)
public interface PresenterComponent {
    void inject(TestMVPActivity testMVPActivity);
}
