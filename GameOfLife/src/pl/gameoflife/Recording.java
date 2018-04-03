package pl.gameoflife;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;

public class Recording implements Runnable {

	private double frameRate = 5;
	private Robot robot;
	private ScheduledExecutorService pool;
	private long startTime;
	private int frameCount = 0;
	private Dimension screenBounds;
	private IMediaWriter writer;

	public Recording(String outputFile) throws AWTException {
		this(outputFile, 5, Quality.MEDIUM);
	}

	public Recording(String ouputFile, double frameRate, Quality quality) throws AWTException {
		this.frameRate = frameRate;
		robot = new Robot();
		writer = ToolFactory.makeWriter(ouputFile);
		screenBounds = calculateScreenBounds();
		writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_MPEG4, screenBounds.width / quality.getDivisor(),
				screenBounds.height / quality.getDivisor());
		pool = Executors.newScheduledThreadPool(1);
	}

	public void startCapture() {
		System.out.println("Starting screen recording");
		startTime = System.nanoTime();
		pool.scheduleAtFixedRate(this, 0L, (long) (1000.0 / frameRate), TimeUnit.MILLISECONDS);
	}

	public void stopCapture() {
		try {
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Screen recording has ended " + frameCount + " images recoreder in video");
		writer.close();
	}

	@Override
	public void run() {
		BufferedImage screen = robot.createScreenCapture(new Rectangle(screenBounds));
		BufferedImage bgrScreen = convertToType(screen, BufferedImage.TYPE_3BYTE_BGR);

		writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
		frameCount++;
	}

	private static Dimension calculateScreenBounds() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screens = ge.getScreenDevices();
		Dimension allScreenBounds = new Dimension();
		for (GraphicsDevice screen : screens) {
			Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
			allScreenBounds.width += screenBounds.width;
			allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);

		}
		return allScreenBounds;
	}

	private BufferedImage convertToType(BufferedImage sourceImage, int targerType) {
		BufferedImage image;
		if (sourceImage.getType() == targerType) {
			image = sourceImage;
		} else {
			image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targerType);
			image.getGraphics().drawImage(sourceImage, 0, 0, null);
		}
		return image;
	}

}
