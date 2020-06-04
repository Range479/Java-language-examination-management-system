import static com.arcsoft.face.toolkit.ImageFactory.getGrayData;
import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.arcsoft.face.ActiveFileInfo;
import com.arcsoft.face.AgeInfo;
import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.Face3DAngle;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.FaceSimilar;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.GenderInfo;
import com.arcsoft.face.IrLivenessInfo;
import com.arcsoft.face.LivenessInfo;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageInfo;

public class MyUseKsFace extends JFrame implements ActionListener {

	JPanel p1, p2, p3, p4,p5;
	JLabel l4, l5, l6;
	JButton b1, b2, b3;
	StuCon dao;
	ImageIcon icon, icon1, icon2;
	stu stu;
	String simg = null;
	double xsd = 0;
	int pd = 0;
	int sid;
	
	public MyUseKsFace(stu stu, int sid) {
		
		this.stu = stu;
		this.sid = sid;

		icon1 = new ImageIcon("img/log/Patientia.jpg");
		simg = "img/log/Patientia.jpg";

		File file = new File("img/use/" + stu.getId() + ".png");
		if (file.exists()) {
			icon1 = new ImageIcon("img/use/" + stu.getId() + ".png");
			simg = "img/use/" + stu.getId() + ".png";
		} 
		
		icon = new ImageIcon("img/log/logo.png");
		icon2 = new ImageIcon("img/log/Patientia.jpg");
		icon1.setImage(icon1.getImage().getScaledInstance(120, 120,  Image.SCALE_DEFAULT));
		icon2.setImage(icon2.getImage().getScaledInstance(120, 120,  Image.SCALE_DEFAULT));
		l5=new JLabel(icon1);
		l6=new JLabel(icon2);
		dao = new StuCon();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		l4=new JLabel("身份验证");
		b1=new JButton("拍照");
		b2=new JButton("识别");
		b3=new JButton("取消");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		p1.add(l4);
		p3.add(l5);
		p4.add(l6);
		p5.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p3,BorderLayout.WEST);
		this.add(p4,BorderLayout.EAST);
		this.add(p5,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		this.setTitle("身份验证");
		this.setBounds(700,300,400,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setIconImage(icon.getImage());// 给窗体设置图标方法
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		JButton b=(JButton)arg0.getSource();
		if(b == b1) {
			try {
				MyUseKsFaceCe.cemera(this);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(b == b2 && pd == 0) {
			 face();
			 pd++;
			 if(xsd > 0.7) {
				 JOptionPane.showMessageDialog(this, "识别成功，即将进入考试页面");
				 this.dispose();
				 new MyUseKsTmAll(sid);
				 return;
			 }
			 else{
				 JOptionPane.showMessageDialog(this, "不是本人，请不要代替他人考试！！！");
				 this.dispose();
				 return;
			 }
		}
	}
	
	public void face() {


        String appId = "";//输入自己注册的
        String sdkKey = "";//输入自己注册的

        FaceEngine faceEngine = new FaceEngine("D:\\Range\\2c307\\虹软\\ArcSoft_ArcFace_Java_Windows_x64_V2.2\\libs\\WIN64");
        //激活引擎
        int activeCode = faceEngine.activeOnline(appId, sdkKey);

        if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("引擎激活失败");
        }

        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);

        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);


        //初始化引擎
        int initCode = faceEngine.init(engineConfiguration);

        if (initCode != ErrorInfo.MOK.getValue()) {
            System.out.println("初始化引擎失败");
        }


        //人脸检测
        ImageInfo imageInfo = getRGBData(new File(simg));
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
       // System.out.println(faceInfoList);

        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
       // System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        //人脸检测2
        ImageInfo imageInfo2 = getRGBData(new File("img/use/timg.png"));
        List<FaceInfo> faceInfoList2 = new ArrayList<FaceInfo>();
        int detectCode2 = faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2);
       // System.out.println(faceInfoList);

        //特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        int extractCode2 = faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2.get(0), faceFeature2);
       // System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        //特征比对
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
        FaceSimilar faceSimilar = new FaceSimilar();
        int compareCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
        xsd = faceSimilar.getScore();


        //人脸属性检测
        FunctionConfiguration configuration = new FunctionConfiguration();
        configuration.setSupportAge(true);
        configuration.setSupportFace3dAngle(true);
        configuration.setSupportGender(true);
        configuration.setSupportLiveness(true);
        int processCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, configuration);


        //性别检测
        List<GenderInfo> genderInfoList = new ArrayList<GenderInfo>();
        int genderCode = faceEngine.getGender(genderInfoList);
//        assertEquals("性别检测失败", genderCode, ErrorInfo.MOK.getValue());
      //  System.out.println("性别：" + genderInfoList.get(0).getGender());

        //年龄检测
        List<AgeInfo> ageInfoList = new ArrayList<AgeInfo>();
        int ageCode = faceEngine.getAge(ageInfoList);
//        assertEquals("年龄检测失败", ageCode, ErrorInfo.MOK.getValue());
       // System.out.println("年龄：" + ageInfoList.get(0).getAge());

        //3D信息检测
        List<Face3DAngle> face3DAngleList = new ArrayList<Face3DAngle>();
        int face3dCode = faceEngine.getFace3DAngle(face3DAngleList);
       // System.out.println("3D角度：" + face3DAngleList.get(0).getPitch() + "," + face3DAngleList.get(0).getRoll() + "," + face3DAngleList.get(0).getYaw());

        //活体检测
        List<LivenessInfo> livenessInfoList = new ArrayList<LivenessInfo>();
        int livenessCode = faceEngine.getLiveness(livenessInfoList);
       // System.out.println("活体：" + livenessInfoList.get(0).getLiveness());


        //IR属性处理
        ImageInfo imageInfoGray = getGrayData(new File(simg));
        List<FaceInfo> faceInfoListGray = new ArrayList<FaceInfo>();
        int detectCodeGray = faceEngine.detectFaces(imageInfoGray.getImageData(), imageInfoGray.getWidth(), imageInfoGray.getHeight(), ImageFormat.CP_PAF_GRAY, faceInfoListGray);

        FunctionConfiguration configuration2 = new FunctionConfiguration();
        configuration2.setSupportIRLiveness(true);
        int processCode2 = faceEngine.processIr(imageInfoGray.getImageData(), imageInfoGray.getWidth(), imageInfoGray.getHeight(), ImageFormat.CP_PAF_GRAY, faceInfoListGray, configuration2);
        //IR活体检测
        List<IrLivenessInfo> irLivenessInfo = new ArrayList<>();
        int livenessIr = faceEngine.getLivenessIr(irLivenessInfo);
       // System.out.println("IR活体：" + irLivenessInfo.get(0).getLiveness());


        //设置活体检测参数
        int paramCode = faceEngine.setLivenessParam(0.8f, 0.8f);


        //获取激活文件信息
        ActiveFileInfo activeFileInfo = new ActiveFileInfo();
        int activeFileCode = faceEngine.getActiveFileInfo(activeFileInfo);

        //引擎卸载
        int unInitCode = faceEngine.unInit();
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try
	    {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
	    UIManager.put("RootPane.setupButtonVisible", false);
		
		new MyUseKsFace(new stu(1001, "111", "123456qwe", 1), 1001);
	}
	

}
