package com.example.personal.Service.Main;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseAbstractService extends BaseService {
    public final Logger logger = LoggerFactory.getLogger(getClass());
}