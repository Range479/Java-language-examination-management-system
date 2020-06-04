import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.github.sarxos.webcam.*;
import com.github.sarxos.webcam.util.ImageUtils;

public class MyUseKsFaceCe {
	private static JFrame window;
	 
	public static void cemera(MyUseKsFace f) throws InterruptedException {
 
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
 
		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);
 
		JFrame window = new JFrame("����ҳ��");
		window.add(panel);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		window.pack();
		window.setVisible(true);
 
 
 
		final JButton button = new JButton("����");
		window.add(panel, BorderLayout.CENTER);
		window.add(button, BorderLayout.SOUTH);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
 
				button.setEnabled(false);  //���ð�ť���ɵ��
 
 
				//ʵ�����ձ���-------start
				String fileName = "img/use/timg";       //����·����ͼƬ���ƣ����üӺ�׺��
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
				SwingUtilities.invokeLater(new Runnable() {
 
					@Override
					public void run()
					{
						JOptionPane.showMessageDialog(null, "���ճɹ�");
						ImageIcon icon = new ImageIcon(fileName + ".png");
						icon.setImage(icon.getImage().getScaledInstance(120, 120,  Image.SCALE_DEFAULT));
						f.l6.setIcon(icon);
						button.setEnabled(true);    //���ð�ť�ɵ��
						return;
					}
				});
				//ʵ�����ձ���-------end
 
			}
		});
	}
}
