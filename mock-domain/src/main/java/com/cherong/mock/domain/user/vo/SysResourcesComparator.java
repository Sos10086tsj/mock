package com.cherong.mock.domain.user.vo;

import java.util.Comparator;

import com.cherong.mock.domain.rabc.model.SysResource;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class SysResourcesComparator implements Comparator<SysResource>{

	@Override
	public int compare(SysResource o1, SysResource o2) {
		Integer seq1 = o1.getHierarchy().getHierarchy() + o1.getSeq();
		Integer seq2 = o2.getHierarchy().getHierarchy() + o2.getSeq();
		return seq1.compareTo(seq2);
	}

}
