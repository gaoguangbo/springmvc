window.qyerUtil.insertStyle([
'.qui-loginFeedback { position:fixed; _position:absolute; z-index:99; top:120px; right:-248px; display:none;}',
'.qui-loginFeedback .icon { position: relative; float:left; margin-right: -1px; width:40px; height:166px; background:url(//static.qyer.com/models/common/component/loginFeedback/icons_feedback.png) 0 0 no-repeat; cursor:pointer;}',
'@media screen and (-webkit-min-device-pixel-ratio: 2), screen and (max-moz-device-pixel-ratio: 2) {',
'.qui-loginFeedback .icon {background:url(//static.qyer.com/models/common/component/loginFeedback/icons_feedback@2x.png) 0 0 no-repeat; background-size: 80px 166px;}',
'}',
'.qui-loginFeedback.js-current > .icon { background-position: -40px 0;}',
'.qui-loginFeedback .cnt { float:left; width:246px; height:280px; border: 1px solid #ccc; border-radius: 0 4px 4px 4px; background-color:#FFF;}',
'.qui-loginFeedback .cnt form { padding:10px; font-size:0;}',
'.qui-loginFeedback .cnt textarea { width:214px; height:128px; padding:2px 5px; border:1px solid #ccc; font-size:12px;}',
'.qui-loginFeedback .cnt .txt { padding:2px 5px; border:1px solid #ccc; font-size:12px; width: 214px; height: 24px;}',
'.qui-loginFeedback .cnt .btn { float:right; margin-top:10px;}',
'.qui-loginFeedback .label { margin-top: 6px; padding: 2px 0; line-height: 24px; font-size: 12px;}',
'.qui-loginFeedback .help { position:relative; top:-1px; border:1px solid #ccc; border-top:none; background:#dcffe2; height:24px; line-height:26px; text-align:center;font-size:12px;}',
'.qui-loginFeedback .help a { color: #3f9f5f;}'
].join(''));

setTimeout(function(){
(function(){



/*
单例模式
 */
var gModel;

function FeedbackClass(){
	this.init();
}
FeedbackClass.prototype = {
	$div: null,

	init: function() {
		this.createDom(); //创建dom结构
		this.bindEvt(); //绑定事件
	},

	tip:function(aOption){
		requirejs(['common/ui/tip/tip'],function(tip){tip.tip(aOption)});
	},

	createDom: function() {
		var divHTML = [
			'<div class="qui-loginFeedback">',
				'<div class="icon js-btn" title="登录意见反馈"></div>',
				'<div class="cnt">',
				'<form method="post">',
					'<textarea class="js-feedback-cnt" cols="50" tabindex="10" rows="10" placeholder="有任何意见或建议请告诉我们"></textarea>',
					'<p class="help">使用遇到问题？请先进入<a href="//bbs.qyer.com/forum-10-1.html" target="_blank">帮助中心</a></p>',
					'<p class="label">联系方式</p>',
					'<input class="txt js-feedback-contact" tabindex="11" type="text" placeholder="请将您的邮箱或手机号码告诉我们">',
					'<input class="btn ui_button js-submitBtn" tabindex="12" type="button" value="提交" class="ui_button">',
				'</form>',
				'</div>',
			'</div>'
		].join("");
		$(document.body).append(divHTML);
		this.$div = $(".qui-loginFeedback").fadeIn(300);
		$div = null;
	},
	showLogin:function(){
		qyerUtil.doLogin();
	},
	bindEvt: function() {
		var me = this;
		this.$div
			.on('click', '.js-btn', function(e) {
				me[(me.$div.hasClass("js-current") ? 'hideDiv' : 'showDiv')]();
			})
			.on('click', 'input.js-submitBtn', function(e){
				var result = me.checkForm();
				if(result){me.submitForm(result);}
			});

		$(document).on('click', function(e) {
			var $target = $(e.target);
			if ($target.closest(".qui-loginFeedback").size() < 1 )  {
				me.hideDiv();
			}
		});
	},

	showDiv: function() {
		var me = this;
		this.$div.animate({"right":0},200, function() {
			me.$div.addClass("js-current");
		});
	},

	hideDiv: function() {
		var me = this;
		this.$div.animate({"right": -248 }, 200, function() {
			me.$div.removeClass("js-current");
		});
	},

	checkValue: {
		cnt: function(aValue) {
			var cnt = $(".js-feedback-cnt").val();
			cnt = $.trim(cnt);
			if ('' == cnt || '有任何意见或建议请告诉我们' == cnt) {
				gModel.tip({text:'意见或建议不能为空', type:'error'});
				return false;
			}
			return cnt;
		},
		contact: function() {
			var contact = $('.js-feedback-contact').val();
			contact = $.trim(contact);
			if (contact == '') {
				gModel.tip({text:'联系方式不能为空', type:'error'});
				return false;
			}
			return contact;
		}
	},

	checkForm:function(){
		var cntCheck = this.checkValue.cnt();
		var contactCheck = this.checkValue.contact();
		if (! cntCheck || ! contactCheck) {
			return false;
		}
		return [cntCheck, ' 联系方式：', contactCheck].join('');
	},

	submitForm: function(cnt) {
		var me = this;
		var option = {
			data:{cnt:cnt, title:'登录反馈', url:location.href},
			onSuccess:function(aJSON){
				me.$div.find("textarea.js-feedback-cnt").val('');
				me.$div.find(".js-feedback-contact").val('');
				gModel.tip({text:aJSON.data.msg});
				me.hideDiv();
			},
			onError:function(aJSON){
				gModel.tip({text:ret.data.msg, type:'error'});
			}
		};
		this.postFeedback(option);
	},
	postFeedback:function(aOption){
		// !true,aOption.testData = {"error_code":0,"result":"ok","data":{"id":1,"msg":"\u611f\u8c22\u60a8\u7684\u610f\u89c1\uff0c\u6211\u4eec\u4f1a\u52aa\u529b\u505a\u5f97\u66f4\u597d\u3002"}};
		aOption.posturl = '/auth.php?action=feedback';
		window.qyerUtil.doAjax(aOption);
	}
};
gModel = new FeedbackClass();
})();
},3000);
