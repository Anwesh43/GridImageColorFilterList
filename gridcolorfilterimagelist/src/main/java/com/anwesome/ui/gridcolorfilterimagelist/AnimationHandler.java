package com.anwesome.ui.gridcolorfilterimagelist;

import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 07/05/17.
 */
public class AnimationHandler  implements ValueAnimator.AnimatorUpdateListener{
    private ColorFilterImageView view;
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    public AnimationHandler(ColorFilterImageView view) {
        this.view = view;
        startAnim.setDuration(500);
        endAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        endAnim.addUpdateListener(this);
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        view.update(factor);
    }
    public void start() {
        startAnim.start();
    }
    public void end() {
        endAnim.start();
    }
}
