package com.demo.springboot.web;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.result.Result;
import com.demo.springboot.util.dao.GsmTaskSpecsDao;
import com.demo.springboot.result.R;

import parameter.SpecsList;
import parameter.SpecsListData;

import com.demo.springboot.entity.GsmTaskSpecs;
import com.demo.springboot.repository.GsmTaskSpecsRepository;
import com.demo.springboot.cfg.JpaConfig;


@RestController
@RequestMapping(value = "/Api/Equip")
public class EquipController {
	private static final Logger logger = LoggerFactory.getLogger(EquipController.class);
	
//	@Autowired
    private GsmTaskSpecsRepository gsmTaskSpecsRepository;
	
	/// <summary>
    /// 获取设备设施分类列
    /// </summary>
    /// <param name="data"></param>
    /// <returns></returns>
	@RequestMapping(value = "/GetSpecsList", method = RequestMethod.POST)
	public Result<List<SpecsList>> GetSpecsList(@RequestBody SpecsListData data) {
		Result<List<SpecsList>> result = new Result<List<SpecsList>>();
        result.Msg = "获取失败";
        
        try
        {
            if (data == null)
            {
                result.Msg = "参数错误";
                return result;
            }
            
            System.out.print("data.ck: ");
            System.out.println(data.ck);
            
            if (null == data.ck ||  data.ck.trim().length() == 0)
            {
                result.Msg = "账套不能为空";
                return result;
            }
            
            GsmTaskSpecsDao gsmTaskSpecsDao = new GsmTaskSpecsDao();
            List <GsmTaskSpecs> lst = gsmTaskSpecsDao.getGsmTaskSpecs();
            
            lst.forEach(s -> System.out.println(s.getIdRank()));
            
            List<SpecsList> lstSpecsList= new ArrayList<SpecsList>();
            for(GsmTaskSpecs g : lst) {
            	System.out.println(g.idRank);
            	SpecsList s = new SpecsList();
            	s.idrank = g.idRank;
				s.idspecs = g.idSpecs;
				s.specdesc = g.specDesc;
				
				lstSpecsList.add(s);
            };
            
            result.Data = lstSpecsList;
            return result;
            
            
//            using (var cxt = P.R(data.ck))
//            {
//                //var iquery = cxt.gsm_task_specs.Where(w => w.inuse == true && w.taskpro == "SB");
//            	GsmTaskSpecs gsm_task_specs = new GsmTaskSpecs();
//            	GsmTaskSpecs gsmTaskSpecs = new GsmTaskSpecs();
//            	gsmTaskSpecs.setTaskPro("SB");
//            	gsmTaskSpecs.setInuse(true);
//                Example<GsmTaskSpecs> gsmTaskSpecsExample = Example.of(gsmTaskSpecs);
//            	
//                Iterable<GsmTaskSpecs> gsmTaskSpecsIter = gsmTaskSpecsRepository.findAll(gsmTaskSpecsExample);
//                
//                List<SpecsList> listSpecsList= new ArrayList<SpecsList>();
//                
//                for(GsmTaskSpecs g : gsmTaskSpecsIter) {
//                	System.out.println(g.idRank);
//                	SpecsList s = new SpecsList();
//                	s.idrank = g.idRank;
//    				s.idspecs = g.idSpecs;
//					s.specdesc = g.specDesc;
//					
//					listSpecsList.add(s);
//                }
//                
//                if(listSpecsList.size() == 0) {
//                	result.Msg = "查无数据";
//                	return result;
//                }
//                
////                for(SpecsList item: lstSpecsList) {
////                	
////                }
//                
//                
////                foreach (var item in db)
////                {
////                    var idvariety = cxt.eqp_equipment_variety.Where(w => w.inuse == true && w.idspecs.Equals(item.idspecs)).Select(s => s.idvariety).ToList();
////                    item.equipnum = cxt.eqp_equipment_data.Where(w => w.inuse == true && idvariety.Contains(w.idvariety)).Count();
////                }
////                
//                result.Data = listSpecsList;
//                result.Code = R.OK;
//                result.WsCode = R.OK;
//                result.Msg = "获取成功";
//            }
        }
        catch (Exception e)
        {
        	result.Msg = "服务异常";
            //result.Msg = "服务异常：" + e.Message;
            //Log.Error(e, "Equip-GetSpecsList；错误：{0}；参数：{1}", e.Message, JsonConvert.SerializeObject(data));
//            System.out.prinln("Equip-GetSpecsList；错误：{0}；参数：{1}", e.Message, JsonConvert.SerializeObject(data))
        }        
        
        System.out.println(result);
        return result;	
	}
}
