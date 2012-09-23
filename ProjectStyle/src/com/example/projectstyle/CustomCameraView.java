package com.example.projectstyle;

import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomCameraView extends SurfaceView implements
		SurfaceHolder.Callback {
	private Camera camera;
	private SurfaceHolder previewHolder;

	public void surfaceCreated(SurfaceHolder holder) {
		camera = Camera.open();

		try {
			camera.setPreviewDisplay(previewHolder);
		} catch (Throwable e) {
		}
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		if (previewHolder.getSurface() == null) {
			// preview surface does not exist
			return;
		}

		// stop preview before making changes
		try {
			camera.stopPreview();
		} catch (Exception e) {
			// ignore: tried to stop a non-existent preview
		}

		// set preview size and make any resize, rotate or
		// reformatting changes here

		// start preview with new settings
		try {
			Parameters params = camera.getParameters();
			params.setPreviewSize(width, height);
			params.setPictureFormat(PixelFormat.JPEG);
			params.set("orientation", "landscape");
			camera.setParameters(params);
			camera.setPreviewDisplay(previewHolder);
			camera.startPreview();

		} catch (Exception e) {
			// Log.d(TAG, "Error starting camera preview: " + e.getMessage());
		}
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		camera.stopPreview();
		camera.release();
	}

	public CustomCameraView(Context ctx) {
		super(ctx);

		previewHolder = this.getHolder();
		previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		previewHolder.addCallback(this);
	}
}