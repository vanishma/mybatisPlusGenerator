package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.maqh.demo.common.JsonBean;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return JsonBean
     */
    JsonBean findListByPage(Integer page, Integer pageCount);

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return JsonBean
     */
    JsonBean add(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return JsonBean
     */
    JsonBean delete(Long id);

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return JsonBean
     */
    JsonBean updateData(${entity} ${entity?uncap_first});

    /**
     * id查询数据
     *
     * @param id id
     * @return JsonBean
     */
    JsonBean findById(Long id);
}
</#if>
