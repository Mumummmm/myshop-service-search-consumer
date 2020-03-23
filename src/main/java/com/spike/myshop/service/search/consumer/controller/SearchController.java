package com.spike.myshop.service.search.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spike.myshop.service.search.api.SearchService;
import com.spike.myshop.service.search.domain.TbItemResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SearchController {

    @Reference(version = "${services.version.search.v1}")
    private SearchService searchService;

    @RequestMapping(value = "search/{query}/{page}/{rows}", method = RequestMethod.GET)
    public List<TbItemResult> search(
            @PathVariable(required = true) String query,
            @PathVariable(required = true) int page,
            @PathVariable(required = true) int rows
    ) {
        return searchService.search(query,page,rows);
    }
}
