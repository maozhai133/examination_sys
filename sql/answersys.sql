/*
 Navicat Premium Data Transfer

 Source Server         : nekotaku
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : answersys

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 04/11/2021 15:27:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `questions` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目',
  `answer_a` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案A',
  `answer_b` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案B',
  `answer_c` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案C',
  `answer_d` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案D',
  `answer_right` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正确答案',
  `questions_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出题人',
  `questions_code` int NOT NULL COMMENT '套题的代码',
  `questions_counter` tinyint NOT NULL COMMENT '题目序号',
  `questions_score` tinyint NOT NULL COMMENT '每题的分值',
  INDEX `question_ibfk_1`(`questions_code`) USING BTREE,
  INDEX `questions_author`(`questions_author`) USING BTREE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`questions_code`) REFERENCES `question_set` (`question_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`questions_author`) REFERENCES `teacher_user` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('感冒忌用下列哪一种食物()', '海鱼', '豆浆', '青菜', '生姜', 'A', '汤姆', 1, 1, 10);
INSERT INTO `question` VALUES ('洗有颜色的衣服时，先用()浸泡10分钟，然后再洗，不容易掉色。', '漂白水', '50%的盐水', '5%的盐水', '醋', 'C', '汤姆', 1, 2, 10);
INSERT INTO `question` VALUES ('柠檬汁有哪些营养含量()', '维生素A和维生素C', '维生素B1和维生素C', '维生素C', '维生素B6', 'A', '汤姆', 1, 3, 10);
INSERT INTO `question` VALUES ('酒中含有酒精，饮酒过多或经常饮酒，会造成酒精中毒，使身体受损，那么，饮酒对人体的哪些器官最为有害?()', '眼睛', '皮肤', '心脏', '肺', 'C', '汤姆', 1, 4, 10);
INSERT INTO `question` VALUES ('苹果中含有增强记忆力的微元素是()', '铁', '锌', '钙', '碘', 'B', '汤姆', 1, 5, 10);
INSERT INTO `question` VALUES ('苹果中含有增强记忆力的微元素是()', '锡中毒', '铅中毒', '铬中毒', '碘中毒', 'B', '汤姆', 1, 6, 10);
INSERT INTO `question` VALUES ('方便面里必然有哪种食品添加剂()', '防腐剂', '合成抗氧化剂', '食用色素', '漂白剂', 'B', '汤姆', 1, 7, 10);
INSERT INTO `question` VALUES ('关于合理饮食有利于健康的下列说法正确的是()', '没有水就没有生命', '饮用水越纯净越好', '养成良好的饮食习惯，多吃蔬菜、水果等碱性食物', '调味剂和营养剂加得越多越好', 'C', '汤姆', 1, 8, 10);
INSERT INTO `question` VALUES ('低盐饮食有利于预防什么疾病?() ', '乙型肝炎', '糖尿病', '高血压', '贫血', 'C', '汤姆', 1, 9, 10);
INSERT INTO `question` VALUES ('碘缺乏会导致儿童、青少年()', '甲亢', '无力', '心理疾病', '生长发育和智力受影响', 'D', '汤姆', 1, 10, 10);
INSERT INTO `question` VALUES ('下列说法中错误的是：（ ）', '人身体可看作是一个系统', '大肠杆菌菌落属于生命系统的种群层次', '一个分子或一个原子不是一个系统', '细胞是最基本的生命系统', 'D', '张三', 5, 1, 10);
INSERT INTO `question` VALUES ('最早创造数字的是:()', '阿拉伯人', '希腊人', '印度人', '罗马人', 'C', '汤姆', 28, 1, 10);
INSERT INTO `question` VALUES ('发现行星运动定律的天文学家是：()', '哥白尼', '伽利略', '开普勒', '张衡', 'B', '汤姆', 28, 2, 10);
INSERT INTO `question` VALUES ('测试题目1', 'A', 'B', 'C', 'D', 'A', '测试教师', 29, 1, 10);
INSERT INTO `question` VALUES ('测试题目2', 'AA', 'BB', 'CC', 'DD', 'C', '测试教师', 29, 2, 10);
INSERT INTO `question` VALUES ('测试题目3', 'AAA', 'BBB', 'CCC', 'DDD', 'B', '测试教师', 29, 3, 10);

-- ----------------------------
-- Table structure for question_set
-- ----------------------------
DROP TABLE IF EXISTS `question_set`;
CREATE TABLE `question_set`  (
  `question_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套题标题',
  `question_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套题作者',
  `question_code` int NOT NULL AUTO_INCREMENT COMMENT '套题代码',
  `question_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出题时间',
  `question_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套题类型',
  `question_username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套题作者用户名',
  `question_totalpoints` tinyint NOT NULL,
  PRIMARY KEY (`question_code`) USING BTREE,
  INDEX `question_title`(`question_title`) USING BTREE,
  INDEX `question_author`(`question_author`) USING BTREE,
  INDEX `question_type`(`question_type`) USING BTREE,
  CONSTRAINT `question_set_ibfk_1` FOREIGN KEY (`question_author`) REFERENCES `teacher_user` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_set
-- ----------------------------
INSERT INTO `question_set` VALUES ('生活大爆炸', '汤姆', 1, '1621396660000', '生活', 'teachertest', 100);
INSERT INTO `question_set` VALUES ('张三的测试题', '张三', 5, '1622597325000', '用户测试', 'jiaoshi', 10);
INSERT INTO `question_set` VALUES ('科技知识小竞赛', '汤姆', 28, '1623591662000', '科技', 'teachertest', 20);
INSERT INTO `question_set` VALUES ('测试套题增加', '测试教师', 29, '1623592241000', '计算机科学与技术', 'jiaoshiceshi', 30);

-- ----------------------------
-- Table structure for stu_result
-- ----------------------------
DROP TABLE IF EXISTS `stu_result`;
CREATE TABLE `stu_result`  (
  `stu_score` tinyint NOT NULL COMMENT '得分',
  `stu_username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生用户名',
  `stu_finishtime` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '完成时间',
  `stu_questioncode` int NOT NULL COMMENT '套题代码',
  `stu_questiontitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套题名称',
  INDEX `stu_result_ibfk_1`(`stu_questioncode`) USING BTREE,
  INDEX `stu_name`(`stu_username`) USING BTREE,
  INDEX `stu_questiontitle`(`stu_questiontitle`) USING BTREE,
  CONSTRAINT `stu_result_ibfk_1` FOREIGN KEY (`stu_questiontitle`) REFERENCES `question_set` (`question_title`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_result
-- ----------------------------
INSERT INTO `stu_result` VALUES (50, 'lvgongwen', '1622297490000', 1, '生活大爆炸');
INSERT INTO `stu_result` VALUES (80, 'stutest', '1622592948000', 1, '生活大爆炸');
INSERT INTO `stu_result` VALUES (40, 'stutest2', '1622601290000', 1, '生活大爆炸');
INSERT INTO `stu_result` VALUES (0, 'lvgongwen', '1623513531000', 5, '张三的测试题');
INSERT INTO `stu_result` VALUES (20, 'stutest', '1623591780000', 28, '科技知识小竞赛');
INSERT INTO `stu_result` VALUES (0, 'xueshengceshi', '1623592096000', 5, '张三的测试题');
INSERT INTO `stu_result` VALUES (30, 'stutest', '1623592461000', 1, '生活大爆炸');

-- ----------------------------
-- Table structure for stu_user
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`username`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_user
-- ----------------------------
INSERT INTO `stu_user` VALUES ('ceshiyonghu', '123456', '测试用');
INSERT INTO `stu_user` VALUES ('lvgongwen', '123456', '吕功文');
INSERT INTO `stu_user` VALUES ('stutest', '123456', '李华');
INSERT INTO `stu_user` VALUES ('stutest2', '123456', '小明');
INSERT INTO `stu_user` VALUES ('xueshengceshi', '123456', '测试试用');

-- ----------------------------
-- Table structure for teacher_user
-- ----------------------------
DROP TABLE IF EXISTS `teacher_user`;
CREATE TABLE `teacher_user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_user
-- ----------------------------
INSERT INTO `teacher_user` VALUES ('jiaoshi', '123456', '张三');
INSERT INTO `teacher_user` VALUES ('jiaoshiceshi', '123456', '测试教师');
INSERT INTO `teacher_user` VALUES ('teachertest', '123456', '汤姆');

SET FOREIGN_KEY_CHECKS = 1;
