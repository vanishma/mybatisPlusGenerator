package com.maqh.demo.controller.temp;

import com.maqh.demo.common.JsonBean;
import com.maqh.demo.common.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.maqh.demo.service.temp.ITempService;
import com.maqh.demo.domain.temp.Temp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author maqh
 * @since 2019-11-21
 */
@Api(tags = {"temp"})
@RestController
@RequestMapping("/temp")
public class TempController {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ITempService tempService;

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectId", value = "项目id"),
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("{projectId}")
    public JsonBean findListByPage(@PathVariable Long projectId,
                                   @RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        try {
            return tempService.findListByPage(projectId, page, pageCount);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "新增数据")
    @PostMapping()
    public JsonBean add(@RequestBody Temp temp){
        try {
            return tempService.add(temp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("{id}")
    public JsonBean delete(@RequestParam("id") Long id){
        try {
            return tempService.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }

    @ApiOperation(value = "更新数据")
    @PutMapping()
    public JsonBean update(@RequestBody Temp temp){
        try {
            return tempService.updateData(temp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonBean.returnResponse(false, ResultCode.SERVICE_ERR);
        }
    }
}
