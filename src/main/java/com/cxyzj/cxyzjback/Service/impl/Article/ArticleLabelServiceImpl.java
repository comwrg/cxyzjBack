package com.cxyzj.cxyzjback.Service.impl.Article;

import com.cxyzj.cxyzjback.Repository.Article.ArticleLabelJpaRepository;
import com.cxyzj.cxyzjback.Service.Interface.Article.ArticleLabelService;
import com.cxyzj.cxyzjback.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 夏
 * @DATE: 2018/10/9 15:14
 * @Description:
 */

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {

    @Autowired
    private ArticleLabelJpaRepository articleLabelJpaRepository;

    private Response response;

    @Override
    public String labelDetails() {
        response = new Response();
        return null;
    }
}
