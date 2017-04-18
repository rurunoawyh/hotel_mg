<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title></title>
  <link rel="stylesheet" href="../css/pintuer.css">
  <link rel="stylesheet" href="../css/admin.css">
  <script src="../js/jquery.js"></script>
  <script src="../js/pintuer.js"></script>
  <script type="text/javascript">
    $(function(){

    });
  </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加客房</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">

      <div class="form-group">
        <div class="label">
          <label>房间号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="roomNum" data-validate="required:请输入房间号" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>房间类型：</label>
        </div>
        <div class="field">
          <select name="roomType" class="input w50">
            <option value="">请选择类型</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
          </select>
           <div class="tips"></div>
         </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>所在楼层：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          1 <input  type="checkbox" />
          2 <input  type="checkbox" />
          3 <input  type="checkbox" />
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
          <select name="warehouseCode" class="input w50">
            <option value="">请选择门店</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
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
          <span>首页</span> <input   type="checkbox" />
          <span>推荐</span> <input   type="checkbox" />
          <span>置顶</span> <input   type="checkbox" />
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
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
          <button class="button bg-main icon-ban-circle" type="button"> 重置</button>
          <button class="button bg-main icon-reply" type="button"> 返回</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>