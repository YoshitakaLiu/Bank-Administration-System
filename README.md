# Bank-Administration-System
# 银行管理系统
!!!! 设计要求：界面部分与后边的业务逻辑处理，要用接口进行分离。!!!!
!!!不要让界面部分与业务逻辑处理混合在一起!!!银行管理系统分为三个模块：登录模块、管理员（即银行操作员）模块和客户模块。
# 登录模块
在登录模块中，以用户名区别管理员和客户。管理员用工号登录，密码也为工号。客户用自己开户时的用户名登录（客户用户名为英文字符串，不得有其他字符），密码为客户在开户时的密码，第一次使用本系统的客户可以通过两种方式开户：○1 通过管理员办理开户，○2通过登录界面的开户按钮开户。不管是管理员还是客户，密码输错三次，该用户名将被锁定，管理员到上一级管理员处重置密码，客户凭有效证件到管理员处重置密码。  管理员（即银行操作员）模块：  在该模块中，会显示操作员工的工号、操作等级和八个按钮（a.开户、b.销户、c.查询用户（顶级操作权）、d.存款、e.取款、f.修改信息、g.修改利率和奖金、h.注销）。  
# 客户模块
该模块会显示客户的用户名和七个相关按钮（a.存款、b.取款、c.查询余额、d.转账、e.修改个人信息、f.修改密码、g.注销）。各个按钮的功能如下： 管理员模块各个按钮的功能如下：  a. 开户：录入客户的姓名（英文字符串），身份证号，电话号码，住址，开户金额，密码由客户输入。点击确定是检查用户名和身份证号码是否合法，若无误，告知已成功；否则，打印错误信息，返回重填；  b. 销户：客户凭本人身份证及密码，在管理员处办理销户； c. 查询客户（顶级操作权）：显示客户的用户名，身份证号，电话，住址，账户余额，利率，存款类别，存款年限，账户活动记录。不可更改客户的信息；  d. 存款：用户名，存款金额，存款类别，存款年限。点击确定，打印客户余额，同时更新数据； e. （放到f里）判断存款金额：判断用户取款金额是否满足要求（满足：进入第7步消除取款信息；不满足：提示所输金额错误） f. 取款：取款金额，用户名，密码。点击确定，打印客户余额，同时更新数据； g. 修改信息：可以更改管理员的登录密码，上一级的管理员可以重置已被禁用的下一级管理员的密码，未被禁用不可更改；管理员可以重置已被禁用的客户密码； h. 修改利率和奖金（顶级操作权）：设置不同类别、不同年限的存款利率及员工的工资和奖金；  i. 注销：退出并关闭系统，回到登录界面。   
客户模块各个按钮的功能如下：  a. 存款：存入金额，更新数据； b. 取款：取出金额，更新数据； c. 查询余额：显示账户的余额；  d. 转账：转入的账号，确认转入的账号，转入的金额。点击确定，检查转入账号是否合法，合法，更新数据；否则，重新输入转入账号； e. 修改个人信息：只可以更改电话号码，住址，用户名及身份证号码不可更改； f. 修改密码：输入一次原密码，和两次确认新密码； g. 注销：退出并关闭系统，回到登录界面。    
