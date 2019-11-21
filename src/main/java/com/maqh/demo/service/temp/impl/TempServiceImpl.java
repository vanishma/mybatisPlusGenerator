package com.maqh.demo.service.temp.impl;

import com.maqh.demo.domain.temp.Temp;
import com.maqh.demo.dao.temp.TempMapper;
import com.maqh.demo.service.temp.ITempService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.maqh.demo.common.JsonBean;
import com.maqh.demo.common.ReturnPageData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maqh
 * @since 2019-11-21
 */
@Service
public class TempServiceImpl extends ServiceImpl<TempMapper, Temp> implements ITempService {

    @Override
    public JsonBean findListByPage(Long projectId, Integer page, Integer pageCount){
        IPage<Temp> wherePage = new Page<>(page, pageCount);
        Temp where = new Temp();

        IPage<Temp> iPage = baseMapper.selectPage(wherePage, Wrappers.query(where));

        return JsonBean.returnResponse(ReturnPageData.fillingData(iPage.getTotal(), iPage.getRecords()));
    }

    @Override
    public JsonBean add(Temp temp){
        baseMapper.insert(temp);
        return JsonBean.returnResponse();
    }

    @Override
    public JsonBean delete(Long id){
        baseMapper.deleteById(id);
        return JsonBean.returnResponse();
    }

    @Override
    public JsonBean updateData(Temp temp){
        baseMapper.updateById(temp);
        return JsonBean.returnResponse();
    }
}
