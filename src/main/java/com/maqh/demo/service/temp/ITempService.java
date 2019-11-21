package com.maqh.demo.service.temp;

import com.maqh.demo.domain.temp.Temp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maqh.demo.common.JsonBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maqh
 * @since 2019-11-21
 */
public interface ITempService extends IService<Temp> {

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
     * @param temp 信息
     * @return JsonBean
     */
    JsonBean add(Temp temp);

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
     * @param temp 信息
     * @return JsonBean
     */
    JsonBean updateData(Temp temp);

}
