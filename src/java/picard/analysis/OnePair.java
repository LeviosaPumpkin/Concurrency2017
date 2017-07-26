package picard.analysis;

import htsjdk.samtools.SAMRecord;
import htsjdk.samtools.reference.ReferenceSequence;

public class OnePair {
	private SAMRecord rec;
	private ReferenceSequence ref;
	public OnePair(SAMRecord rec_, ReferenceSequence ref_){
		this.rec = rec_;
		this.ref = ref_;
	}
	public SAMRecord getRec(){
		return rec;
	}
	public ReferenceSequence getRef(){
		return ref;
	}
}