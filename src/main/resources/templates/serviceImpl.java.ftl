package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.maqh.demo.common.JsonBean;
import com.maqh.demo.common.ReturnPageData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public JsonBean findListByPage(Integer page, Integer pageCount){
        IPage<${entity}> wherePage = new Page<>(page, pageCount);
        ${entity} where = new ${entity}();

        IPage<${entity}> iPage = baseMapper.selectPage(wherePage, Wrappers.query(where));

        return JsonBean.returnResponse(ReturnPageData.fillingData(iPage.getTotal(), iPage.getRecords()));
    }

    @Override
    public JsonBean add(${entity} ${entity?uncap_first}){
        baseMapper.insert(${entity?uncap_first});
        return JsonBean.returnResponse();
    }

    @Override
    public JsonBean delete(Long id){
        baseMapper.deleteById(id);
        return JsonBean.returnResponse();
    }

    @Override
    public JsonBean updateData(${entity} ${entity?uncap_first}){
        baseMapper.updateById(${entity?uncap_first});
        return JsonBean.returnResponse();
    }

    @Override
    public JsonBean findById(Long id){
        ${entity} ${entity?uncap_first} = baseMapper.selectById(id);
        return JsonBean.returnResponse(${entity?uncap_first});
    }
}
</#if>
