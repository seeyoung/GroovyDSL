	// Korean DSL using GEP3 rules
	Object.metaClass.을 =
	Object.metaClass.를 =
	Object.metaClass.의 =
		{clos ->clos(delegate) }
	
	먼저 = { it }
	표시하라 = { println it }
	제곱근 = { Math.sqrt(it) }
	
	먼저 100 의 제곱근 을 표시하라 
	먼저(100).의(제곱근).을(표시하라)
	