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
     * 查询分页数据
     *
     * @param projectId 项目id
     * @param page      页码
     * @param pageCount 每页条数
     * @return JsonBean
     */
    JsonBean findListByPage(Long projectId, Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param ${entity?uncap_first} 信息
     * @return JsonBean
     */
    JsonBean add(${entity} ${entity?uncap_first});

    /**
     * 删除
     *
     * @param id 主键
     * @return JsonBean
     */
    JsonBean delete(Long id);

    /**
     * 修改信息
     *
     * @param ${entity?uncap_first} 信息
     * @return JsonBean
     */
    JsonBean updateData(${entity} ${entity?uncap_first});

}
</#if>
