package ${package.Controller};

import com.maqh.demo.common.JsonBean;
import com.maqh.demo.common.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if><#else><#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{<#else>public class ${table.controllerName} {</#if>

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping()
    public JsonBean add(@RequestBody ${entity} ${entity?uncap_first}){
        try {
            return ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first});
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("{id}")
    public JsonBean delete(@PathVariable("id") Long id){
        try {
            return ${(table.serviceName?substring(1))?uncap_first}.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping()
    public JsonBean update(@RequestBody ${entity} ${entity?uncap_first}){
        try {
            return ${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first});
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "查询${table.comment!}分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public JsonBean findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        try {
            return ${(table.serviceName?substring(1))?uncap_first}.findListByPage(page, pageCount);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "id查询${table.comment!}")
    @GetMapping("{id}")
    public JsonBean findById(@PathVariable Long id){
        try {
            return ${(table.serviceName?substring(1))?uncap_first}.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

}
</#if>