package com.apress.spring.health

class QuotaException(maxSize: Long) :
    Exception("할당량 초과. 최대 할당량: $maxSize. 할당량 정책은 관리자에게 문의하세요.")
