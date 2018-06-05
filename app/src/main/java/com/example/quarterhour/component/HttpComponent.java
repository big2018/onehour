package com.example.quarterhour.component;

import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.recommend.fragment.GuanZhuFragment;
import com.example.quarterhour.ui.recommend.fragment.HotFragment;
import com.example.quarterhour.ui.recommend.fragment.RecommendFragment;

import dagger.Component;
import dagger.Module;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(HotFragment hotFragment);
    void inject(GuanZhuFragment guanZhuFragment);
}
