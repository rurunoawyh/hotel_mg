<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="head.jsp"></jsp:include>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加客房</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">

      <div class="form-group">
        <div class="label">
          <label>房间号：</label>
        </div>
        <div class="field">
          <input id="roomNum" type="text" class="input w50" value="" name="roomNum" data-validate="required:请输入房间号" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>房间类型：</label>
        </div>
        <div class="field">
          <select id="roomTypeSelect" name="roomType" class="input w50">
            <option value="">请选择类型</option>
          </select>
           <div class="tips"></div>
         </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>所在楼层：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          1 <input name="floorNum" value="1"  type="radio" />
          2 <input name="floorNum" value="2"  type="radio" />
          4 <input name="floorNum" value="3"  type="radio" />
          5 <input name="floorNum" value="4"  type="radio" />
          6 <input name="floorNum" value="5"  type="radio" />
          7 <input name="floorNum" value="6"  type="radio" />
          8 <input name="floorNum" value="7"  type="radio" />
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="privice" data-validate="required:请输入价格" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>所属门店：</label>
        </div>
        <div class="field">
          <select id="warehouse" name="warehouseCode" class="input w50">
            <option value="">请选择门店</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>面积：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="roomArea" data-validate="required:请输入单位为㎡" /><span id="uint"></span>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>实体图片：</label>
        </div>
        <div class="field">
          <input type="text" id="url2" name="img" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image2" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>设备：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          <span>有窗</span> <input   type="checkbox" />
          <span>大床(1.5m)</span> <input   type="checkbox" />
          <span>双床</span> <input   type="checkbox" />
          <span>无线</span> <input   type="checkbox" />
          <span>浴室</span> <input   type="checkbox" />
          <span>液晶电视</span> <input   type="checkbox" />
          <span>零食</span> <input   type="checkbox" />
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="roomDescribe" style=" height:90px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button"> 提交</button>
          <button class="button bg-main icon-ban-circle" type="button"> 重置</button>
          <button class="button bg-main icon-reply" type="button"> 返回</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
    $(function(){
        //检查房间号
        $("#roomNum").blur(function(){checkRoomNum()});
        //初始化房间类型
        initRoomType();
        //选择门店
        initWarehouse();
        //检查房间类型
        function checkRoomNum(){
            $.ajax({
                url:"${pageContext.request.contextPath}/guestroom/checkRoomNum.json",
                data:{"roomNum":$('#roomNum').val()},
                dateType:"json",
                success:function(data){
                    if(data.status==true){
                        return true;
                    }if (data.status==false){
                        alertMsg(data.msg);
                        return false;
                    }

                }
            });
        }

        function initRoomType() {
            $.ajax({
                url:"${pageContext.request.contextPath}/enum/roomTypeEnum.json",
                data:{},
                dateType:"json",
                success:function(data){
                    for (var opt=0; opt<data.length;opt++){
                        $('#roomTypeSelect').append("<option value='"+data[opt].key+"'>"+data[opt].value+"</option>");
                    }
                }
            });
        }

        function initWarehouse() {
            $.ajax({
                url:"${pageContext.request.contextPath}/warehouse/codeName.json",
                data:{},
                dateType:"json",
                success:function(data){
                    var list =data.result;
                    for (var opt=0; opt<list.length;opt++){
                        $('#warehouse').append("<option value='"+list[opt].code+"'>"+list[opt].value+"</option>");
                    }
                }
            });
        }
    });

</script>
<jsp:include page="foot.jsp"></jsp:include>