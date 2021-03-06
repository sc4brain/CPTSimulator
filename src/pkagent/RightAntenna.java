package pkagent;

import java.awt.geom.Point2D;

import pkfield.Field;

public class RightAntenna implements OdorSensor {
	private Point2D.Double gp;
	private double angle;
	private Point2D.Double spR;
	private double k = 5; // mm
	private double f = 10; //mm
	private boolean stimuR = false;
	private Field fd;
	
	
	public RightAntenna(Field fd_, Point2D.Double gp_, double angle_){
		fd = fd_;
		gp = gp_;
		angle = angle_;
		spR = new Point2D.Double(gp.x + f * Math.cos(angle) + k
				* Math.cos(angle - Math.PI / 2), gp.y + f * Math.sin(angle) + k
				* Math.sin(angle - Math.PI / 2));
	
	}
	
	
	public void move(Point2D.Double gp_, double angle_){
		gp = gp_;
		angle = angle_;
		spR.setLocation(gp.x + f * Math.cos(angle) + k * Math.cos(angle - Math.PI / 2),
				gp.y  + f * Math.sin(angle)+ k * Math.sin(angle - Math.PI / 2));
	
	}
	
	public boolean isSense(double rand){
		stimuR = false;
		if (rand <= fd.getRate(spR.x, spR.y)) {
			stimuR = true;
		}
		//System.out.println(fd.getRate(spR.x, spR.y));
		return stimuR;
	}
	
	public double getPotential(){
		return -1;
	}

		public Point2D.Double getap() {
		return spR;
	}
}
