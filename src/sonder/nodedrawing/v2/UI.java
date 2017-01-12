package sonder.nodedrawing.v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField tfWidth;
	private JTextField tfHeight;
	private JTextField tfOriginX;
	private JTextField tfOriginY;
	private JTextField tfRange;
	private JTextField tfTiers;
	private JTextField tfMin;
	private JTextField tfMax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UI() throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 556);
		setTitle("Node Drawing v2");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHead = new JLabel("Node Drawing - v2.0");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(47, 11, 133, 14);
		contentPane.add(lblHead);
		
		JLabel lblCanvasOptions = new JLabel("Canvas Options");
		lblCanvasOptions.setBounds(10, 36, 108, 14);
		contentPane.add(lblCanvasOptions);
		
		tfWidth = new JTextField();
		tfWidth.setText("800");
		tfWidth.setBounds(67, 61, 33, 20);
		contentPane.add(tfWidth);
		tfWidth.setColumns(10);
		
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(20, 64, 36, 14);
		contentPane.add(lblWidth);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(20, 89, 36, 14);
		contentPane.add(lblHeight);
		
		tfHeight = new JTextField();
		tfHeight.setText("800");
		tfHeight.setColumns(10);
		tfHeight.setBounds(67, 86, 33, 20);
		contentPane.add(tfHeight);
		
		JLabel lblUseOrigin = new JLabel("Use origin");
		lblUseOrigin.setBounds(20, 114, 60, 14);
		contentPane.add(lblUseOrigin);
		
		tfOriginX = new JTextField();
		tfOriginX.setText("400");
		tfOriginX.setBounds(77, 111, 40, 20);
		contentPane.add(tfOriginX);
		tfOriginX.setColumns(10);
		
		JLabel label = new JLabel(",");
		label.setBounds(123, 117, 16, 14);
		contentPane.add(label);
		
		tfOriginY = new JTextField();
		tfOriginY.setText("400");
		tfOriginY.setColumns(10);
		tfOriginY.setBounds(130, 111, 40, 20);
		contentPane.add(tfOriginY);
		
		JLabel lblGenerationOptions = new JLabel("Generation Options");
		lblGenerationOptions.setBounds(10, 185, 133, 14);
		contentPane.add(lblGenerationOptions);
		
		JSlider sliderBranches = new JSlider();
		sliderBranches.setMajorTickSpacing(5);
		sliderBranches.setValue(3);
		sliderBranches.setPaintTicks(true);
		sliderBranches.setMinorTickSpacing(1);
		sliderBranches.setMaximum(10);
		sliderBranches.setMinimum(1);
		sliderBranches.setBounds(20, 233, 200, 14);
		contentPane.add(sliderBranches);
		
		JLabel lblBranches = new JLabel("Branches");
		lblBranches.setBounds(20, 209, 150, 14);
		contentPane.add(lblBranches);
		
		JLabel lblMRange = new JLabel("Range for movement");
		lblMRange.setBounds(20, 258, 160, 14);
		contentPane.add(lblMRange);
		
		JLabel lblPlusMinus = new JLabel("+ -");
		lblPlusMinus.setBounds(34, 283, 23, 14);
		contentPane.add(lblPlusMinus);
		
		tfRange = new JTextField();
		tfRange.setText("60");
		tfRange.setColumns(10);
		tfRange.setBounds(55, 280, 40, 20);
		contentPane.add(tfRange);
		
		JLabel lblOne = new JLabel("1");
		lblOne.setBounds(10, 233, 16, 14);
		contentPane.add(lblOne);
		
		JLabel lblTen = new JLabel("10");
		lblTen.setBounds(226, 233, 16, 14);
		contentPane.add(lblTen);
		
		JLabel lblTiers = new JLabel("Tiers");
		lblTiers.setBounds(20, 139, 46, 14);
		contentPane.add(lblTiers);
		
		tfTiers = new JTextField();
		tfTiers.setText("3");
		tfTiers.setColumns(10);
		tfTiers.setBounds(67, 136, 40, 20);
		contentPane.add(tfTiers);
		
		JLabel lblDistance = new JLabel("Movement range");
		lblDistance.setBounds(20, 310, 160, 14);
		contentPane.add(lblDistance);
		
		JLabel lblMin = new JLabel("min ->");
		lblMin.setBounds(34, 335, 33, 14);
		contentPane.add(lblMin);
		
		tfMin = new JTextField();
		tfMin.setText("20");
		tfMin.setColumns(10);
		tfMin.setBounds(70, 332, 40, 20);
		contentPane.add(tfMin);
		
		JLabel lblMax = new JLabel("max ->");
		lblMax.setBounds(123, 335, 36, 14);
		contentPane.add(lblMax);
		
		tfMax = new JTextField();
		tfMax.setText("60");
		tfMax.setColumns(10);
		tfMax.setBounds(162, 332, 40, 20);
		contentPane.add(tfMax);
		
		JLabel lblDisplayOptions = new JLabel("Display Options");
		lblDisplayOptions.setBounds(10, 387, 133, 14);
		contentPane.add(lblDisplayOptions);
		
		JRadioButton rdbtnNodeIDs = new JRadioButton("Show node IDs");
		rdbtnNodeIDs.setBounds(20, 410, 109, 14);
		contentPane.add(rdbtnNodeIDs);
		
		JRadioButton rdbtnNodeRelations = new JRadioButton("Show node relations");
		rdbtnNodeRelations.setSelected(true);
		rdbtnNodeRelations.setBounds(20, 432, 139, 14);
		contentPane.add(rdbtnNodeRelations);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options.CANVAS_WIDTH = Integer.parseInt(tfWidth.getText());
				Options.CANVAS_HEIGHT = Integer.parseInt(tfHeight.getText());
				Options.ORIGIN_X = Integer.parseInt(tfOriginX.getText());
				Options.ORIGIN_Y = Integer.parseInt(tfOriginY.getText());
				Options.TIERS = Integer.parseInt(tfTiers.getText());
				Options.ANGLE_RANGE = Integer.parseInt(tfRange.getText());
				Options.BRANCHES = sliderBranches.getValue();
				Options.MOVEMENT_RANGE_MAX = Integer.parseInt(tfMax.getText());
				Options.MOVEMENT_RANGE_MIN = Integer.parseInt(tfMin.getText());
				Options.SHOW_IDS = rdbtnNodeIDs.isSelected();
				Options.SHOW_RELATIONS = rdbtnNodeRelations.isSelected();
				
				Colors.randomSet(Options.TIERS);
				
				Canvas canvas = Generator.web(Options.CANVAS_WIDTH, Options.CANVAS_HEIGHT, Options.TIERS, Options.BRANCHES);
				RenderPanel render = new RenderPanel(canvas, Options.SHOW_RELATIONS, Options.SHOW_IDS);
				JFrame frame = new JFrame();
				frame.setContentPane(render);
				frame.setSize(Options.CANVAS_WIDTH, Options.CANVAS_HEIGHT);
				frame.setVisible(true);
			}
		});
		
		btnGenerate.setBounds(10, 483, 232, 23);
		contentPane.add(btnGenerate);
		
		
	}
}
