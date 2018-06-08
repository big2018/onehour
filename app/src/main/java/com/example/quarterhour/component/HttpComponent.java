package com.example.quarterhour.component;

import com.example.quarterhour.module.HttpModule;
import com.example.quarterhour.ui.details.DetailsActivity;
import com.example.quarterhour.ui.jokes.fragment.JokeFragment;
import com.example.quarterhour.ui.recommend.fragment.GuanZhuFragment;
import com.example.quarterhour.ui.recommend.fragment.HotFragment;
import com.example.quarterhour.ui.recommend.fragment.RecommendFragment;
import com.example.quarterhour.ui.video.fragment.HotFrag;
import com.example.quarterhour.ui.video.fragment.NearbyFrag;

import dagger.Component;
import dagger.Module;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(HotFragment hotFragment);
    void inject(GuanZhuFragment guanZhuFragment);
    void inject(JokeFragment jokesFragment);
    void inject(DetailsActivity detailsActivity);
    void inject(HotFrag hotFrag);
    void inject(NearbyFrag nearbyFrag);
}
