package dk.itu.sdg.tracemodel.runtimedata;

import org.aspectj.lang.JoinPoint;

public class Trace {
	
	private Object leftHand;
	private Object rightHand;
	private JoinPoint joinPoint;
	
	public Trace(Object leftHand, JoinPoint joinPoint, Object rightHand) {
		this.leftHand = leftHand;
		this.joinPoint = joinPoint;
		this.rightHand = rightHand;
	}
	
	@Override
	public int hashCode() {	
		int hash = 17 * 31;
		hash += leftHand.hashCode();
		hash += rightHand.hashCode();
		hash += joinPoint.toLongString().hashCode();
		return hash;		
	};
	
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Trace) {
			Trace otherTrace = (Trace) obj;
			
			if(otherTrace.getLeftHand().equals(this.leftHand)  
					&& this.rightHand.equals(this.rightHand)
					&& otherTrace.getJoinPoint().getKind().equals(this.joinPoint.getKind())
					&& otherTrace.getJoinPoint().toLongString().equals(this.joinPoint.toLongString())
					) {
				return true;
			}
				
		}
		return false;
	}

	public boolean similar(Object obj) {

		if (obj instanceof Trace) {
			Trace otherTrace = (Trace) obj;
			
			if(otherTrace.getLeftHand().equals(this.leftHand) && this.rightHand.equals(this.rightHand) 
					&& !otherTrace.getJoinPoint().toLongString().equals(this.joinPoint.toLongString())) {
				return true;
			}	
		}
		return false;
	}
	
	public Object getLeftHand() {
		return leftHand;
	}

	public Object getRightHand() {
		return rightHand;
	}

	public JoinPoint getJoinPoint() {
		return joinPoint;
	}

}
