package com.gemserk.resources.slick.dataloaders;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.gemserk.resources.dataloaders.DataLoader;

public class SlickAnimationLoader extends DataLoader<Animation> {

	private final int totalFrames;

	private final boolean autoUpdate;

	private int time;

	private final String file;

	private final int tw;

	private final int th;

	public SlickAnimationLoader(String file, int tw, int th, int time, int totalFrames, boolean autoUpdate) {
		this.file = file;
		this.tw = tw;
		this.th = th;
		this.totalFrames = totalFrames;
		this.autoUpdate = autoUpdate;
		this.time = time;
	}

	@Override
	public Animation load() {
		try {
			return createAnimation(new SpriteSheet(new Image(file), tw, th), totalFrames, time, autoUpdate);
		} catch (SlickException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Load an animation specifying total frames from a spritesheet.
	 */
	private Animation createAnimation(SpriteSheet spriteSheet, int totalFrames, int time, boolean autoUpdate) {
		Animation animation = new Animation();
		animation.setAutoUpdate(autoUpdate);

		int horizontalCant = spriteSheet.getHorizontalCount();
		int verticalCant = spriteSheet.getVerticalCount();

		for (int j = 0; j < verticalCant; j++) {
			for (int i = 0; i < horizontalCant; i++) {
				if (i + j * horizontalCant < totalFrames) {
					animation.addFrame(spriteSheet.getSubImage(i, j), time);
				}
			}
		}

		return animation;
	}
}