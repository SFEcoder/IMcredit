-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: huaqi
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `browse`
--

DROP TABLE IF EXISTS `browse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `browse` (
  `user_id` int NOT NULL,
  `ep_id` int NOT NULL,
  `create_time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `browse`
--

LOCK TABLES `browse` WRITE;
/*!40000 ALTER TABLE `browse` DISABLE KEYS */;
INSERT INTO `browse` VALUES (1,1,'2021/3/2上午9:50:23'),(1,2,'2021/2/28下午7:34:48'),(1,3,'2021/2/28下午7:52:09'),(1,4,'2021/3/2上午10:23:14');
/*!40000 ALTER TABLE `browse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enterprise`
--

DROP TABLE IF EXISTS `enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enterprise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `license` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `register_number` varchar(255) NOT NULL,
  `user_type` int DEFAULT '1',
  `valid` tinyint(1) DEFAULT '0',
  `e_photo` varchar(255) DEFAULT NULL,
  `e_grade` int DEFAULT NULL,
  `financial_score` double DEFAULT NULL,
  `diver_score` double DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `register_number` (`register_number`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise`
--

LOCK TABLES `enterprise` WRITE;
/*!40000 ALTER TABLE `enterprise` DISABLE KEYS */;
INSERT INTO `enterprise` VALUES (1,'123@qq.com','123456','企业一号','https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c','12345678','2513','1234553223',1,0,'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2142681104',1,3,0.14858365296005677,0.43731807434158676,1),(2,'223@qq.com','123456','企业二号','https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c','12345678','assd','2234553223',1,0,'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3873176210,2387858924&fm=26&gp=0.jpg',1,13.25,0.23462045209419397,0.3600614039028313,1),(3,'323@qq.com','123456','企业三号','https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c','12345678','assd','3234553223',1,0,'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2305905861,3554423072&fm=26&gp=0.jpg',2,11.56984126984127,0.14858365296005677,0.2026205217555819,1),(4,'423@qq.com','123456','企业四号','https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c','12345678','assd','4234553223',1,0,'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2587530696,1745062568&fm=26&gp=0.jpg',3,10,0.46821224198569245,60,1),(5,'222','123456','企业五号','https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c','12345678','asdf','3215646984',1,0,'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=358258887,346107986&fm=26&gp=0.jpg',4,10,20,10,1),(6,'333','123456','企业6号','654','654658','65464','65465468',1,0,'https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=785454b5a41c8701c9b6b4e6177f9e6e/0d338744ebf81a4c07280698c02a6059252da64d.jpg',1,10,20,20,1),(7,'123','123345`','123','1','123','asdf','132654654',1,0,'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=81332416,178973271&fm=26&gp=0.jpg',1,21,12,20,1),(8,'31212','123465','654','123','65465','45646','654654654',1,0,'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=51743081,2249836563&fm=26&gp=0.jpg',1,12,21,32,1),(9,'2513@qq.com','123456','yunthin','','4558','zrx','89w',1,0,NULL,NULL,NULL,NULL,NULL,NULL),(10,'22513@qq.com','123456','98','https://huaqi-storage.oss-cn-beijing.aliyuncs.com/storage/96a23ee4d91e46118962cc2f0f07b73dimage-20201225160236936.png','4558','985','98',1,0,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financialindex`
--

DROP TABLE IF EXISTS `financialindex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financialindex` (
  `enterprise_id` int DEFAULT NULL,
  `ttm` double DEFAULT NULL,
  `debt_ratio` double DEFAULT NULL,
  `current_ratio` double DEFAULT NULL,
  `quick_ratio` double DEFAULT NULL,
  `cf_cl` double DEFAULT NULL,
  `ttal` double DEFAULT NULL,
  `operating_revenue` double DEFAULT NULL,
  `total_profit` double DEFAULT NULL,
  `total_liabilities` double DEFAULT NULL,
  `roe` double DEFAULT NULL,
  `profit_rate` double DEFAULT NULL,
  `gross_profit` double DEFAULT NULL,
  `fe_rev` double DEFAULT NULL,
  `turnover_days` double DEFAULT NULL,
  `current_assets` double DEFAULT NULL,
  `accounts_receivable` double DEFAULT NULL,
  `ebit_rev` double DEFAULT NULL,
  `industry_prosperity` double DEFAULT NULL,
  `ttm_p` double DEFAULT NULL,
  `debt_ratio_p` double DEFAULT NULL,
  `current_ratio_p` double DEFAULT NULL,
  `quick_ratio_p` double DEFAULT NULL,
  `cf_cl_p` double DEFAULT NULL,
  `ttal_p` double DEFAULT NULL,
  `operating_revenue_p` double DEFAULT NULL,
  `total_profit_p` double DEFAULT NULL,
  `total_liabilities_p` double DEFAULT NULL,
  `roe_p` double DEFAULT NULL,
  `profit_rate_p` double DEFAULT NULL,
  `gross_profit_p` double DEFAULT NULL,
  `fe_rev_p` double DEFAULT NULL,
  `turnover_days_p` double DEFAULT NULL,
  `current_assets_p` double DEFAULT NULL,
  `accounts_receivable_p` double DEFAULT NULL,
  `ebit_rev_p` double DEFAULT NULL,
  `industry_prosperity_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financialindex`
--

LOCK TABLES `financialindex` WRITE;
/*!40000 ALTER TABLE `financialindex` DISABLE KEYS */;
INSERT INTO `financialindex` VALUES (2,1,2,3,4,5,6,8,8,7,8,9,8,7,8,9,8,7,8,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333),(3,4,5,6,8,4,4,4,4,4,4,4,4,4,4,4,4,4,4,33.33333333333333,33.33333333333333,33.33333333333333,33.33333333333333,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666,66.66666666666666),(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100);
/*!40000 ALTER TABLE `financialindex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massdiscrete`
--

DROP TABLE IF EXISTS `massdiscrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `massdiscrete` (
  `enterprise_id` int DEFAULT NULL,
  `on_time_delivery_rate` double DEFAULT NULL,
  `system_manage_level` double DEFAULT NULL,
  `emergency_response` double DEFAULT NULL,
  `budget_management` double DEFAULT NULL,
  `auto_instruction_content` double DEFAULT NULL,
  `environmental_management` double DEFAULT NULL,
  `energy_management` double DEFAULT NULL,
  `social_contribution` double DEFAULT NULL,
  `business_collaboration` double DEFAULT NULL,
  `value_network_collaboration` double DEFAULT NULL,
  `tracking_and_feedback` double DEFAULT NULL,
  `organizational_model` double DEFAULT NULL,
  `maintenance_investment` double DEFAULT NULL,
  `plan_implementation` double DEFAULT NULL,
  `decision_support` double DEFAULT NULL,
  `equipment_management` double DEFAULT NULL,
  `hr_management` double DEFAULT NULL,
  `on_time_delivery_rate_p` double DEFAULT NULL,
  `system_manage_level_p` double DEFAULT NULL,
  `emergency_response_p` double DEFAULT NULL,
  `budget_management_p` double DEFAULT NULL,
  `auto_instruction_content_p` double DEFAULT NULL,
  `environmental_management_p` double DEFAULT NULL,
  `energy_management_p` double DEFAULT NULL,
  `social_contribution_p` double DEFAULT NULL,
  `business_collaboration_p` double DEFAULT NULL,
  `value_network_collaboration_p` double DEFAULT NULL,
  `tracking_and_feedback_p` double DEFAULT NULL,
  `organizational_model_p` double DEFAULT NULL,
  `maintenance_investment_p` double DEFAULT NULL,
  `plan_implementation_p` double DEFAULT NULL,
  `decision_support_p` double DEFAULT NULL,
  `equipment_management_p` double DEFAULT NULL,
  `hr_management_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massdiscrete`
--

LOCK TABLES `massdiscrete` WRITE;
/*!40000 ALTER TABLE `massdiscrete` DISABLE KEYS */;
INSERT INTO `massdiscrete` VALUES (2,100,4,2,-5,5,3,3,39.43,9,1,5,65,3,1,4,4,4,25,25,25,100,25,25,25,50,25,50,25,25,50,50,25,25,25),(3,100,0,1,0,-1,0,0,20,0,1,1,40,0,1,1,0,1,25,100,75,50,75,75,75,75,100,50,100,75,75,50,75,100,100),(4,99,4,2,-3,-5,0,0,43,2,0,2,42,0,1,0,2,3,75,25,25,75,100,75,75,25,75,100,50,50,75,50,100,50,50),(1,80,2,1,3,3,2,3,12,7,2,2,6,32,5,2,2,2,100,75,75,25,50,50,25,100,50,25,50,100,25,25,50,50,75);
/*!40000 ALTER TABLE `massdiscrete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mixindustry`
--

DROP TABLE IF EXISTS `mixindustry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mixindustry` (
  `enterprise_id` int DEFAULT NULL,
  `system_manage_level` double DEFAULT NULL,
  `test_data_rate` double DEFAULT NULL,
  `tracking_oforders` double DEFAULT NULL,
  `online_purchasing_rate` double DEFAULT NULL,
  `collection_of_energy_data` double DEFAULT NULL,
  `auto_instruction_content` double DEFAULT NULL,
  `monitoring_coverage` double DEFAULT NULL,
  `environmental_management` double DEFAULT NULL,
  `info_exchange_and_sharing` double DEFAULT NULL,
  `value_network_collaboration` double DEFAULT NULL,
  `green_development` double DEFAULT NULL,
  `social_contribution` double DEFAULT NULL,
  `information_investment` double DEFAULT NULL,
  `equipment_assets` double DEFAULT NULL,
  `organizational_model` double DEFAULT NULL,
  `informatization_plan_implementation` double DEFAULT NULL,
  `material_requirements` double DEFAULT NULL,
  `business_scope` double DEFAULT NULL,
  `equipment_management` double DEFAULT NULL,
  `hr_management` double DEFAULT NULL,
  `industrial_software_innovation` double DEFAULT NULL,
  `system_manage_level_p` double DEFAULT NULL,
  `test_data_rate_p` double DEFAULT NULL,
  `tracking_oforders_p` double DEFAULT NULL,
  `online_purchasing_rate_p` double DEFAULT NULL,
  `collection_of_energy_data_p` double DEFAULT NULL,
  `auto_instruction_content_p` double DEFAULT NULL,
  `monitoring_coverage_p` double DEFAULT NULL,
  `environmental_management_p` double DEFAULT NULL,
  `info_exchange_and_sharing_p` double DEFAULT NULL,
  `value_network_collaboration_p` double DEFAULT NULL,
  `green_development_p` double DEFAULT NULL,
  `social_contribution_p` double DEFAULT NULL,
  `information_investment_p` double DEFAULT NULL,
  `equipment_assets_p` double DEFAULT NULL,
  `organizational_model_p` double DEFAULT NULL,
  `informatization_plan_implementation_p` double DEFAULT NULL,
  `material_requirements_p` double DEFAULT NULL,
  `business_scope_p` double DEFAULT NULL,
  `equipment_management_p` double DEFAULT NULL,
  `hr_management_p` double DEFAULT NULL,
  `industrial_software_innovation_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mixindustry`
--

LOCK TABLES `mixindustry` WRITE;
/*!40000 ALTER TABLE `mixindustry` DISABLE KEYS */;
/*!40000 ALTER TABLE `mixindustry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procindustry`
--

DROP TABLE IF EXISTS `procindustry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procindustry` (
  `enterprise_id` int DEFAULT NULL,
  `system_manage_level` double DEFAULT NULL,
  `budget_management` double DEFAULT NULL,
  `auto_upload_info_range` double DEFAULT NULL,
  `auto_instruction_content` double DEFAULT NULL,
  `auto_information_coverage` double DEFAULT NULL,
  `auto_instruction_situation` double DEFAULT NULL,
  `integrated_management_cover` double DEFAULT NULL,
  `online_purchasing_rate` double DEFAULT NULL,
  `min_scheduling_unit` double DEFAULT NULL,
  `energy_management` double DEFAULT NULL,
  `social_contribution` double DEFAULT NULL,
  `business_collaboration` double DEFAULT NULL,
  `info_exchange_and_sharing` double DEFAULT NULL,
  `value_network_collaboration` double DEFAULT NULL,
  `green_development` double DEFAULT NULL,
  `maintenance_investment` double DEFAULT NULL,
  `organizational_model` double DEFAULT NULL,
  `plan_implementation` double DEFAULT NULL,
  `material_requirements` double DEFAULT NULL,
  `research_development` double DEFAULT NULL,
  `business_scope` double DEFAULT NULL,
  `equipment_management` double DEFAULT NULL,
  `hr_management` double DEFAULT NULL,
  `industrial_software_innovation` double DEFAULT NULL,
  `output_value` double DEFAULT NULL,
  `system_manage_level_p` double DEFAULT NULL,
  `budget_management_p` double DEFAULT NULL,
  `auto_upload_info_range_p` double DEFAULT NULL,
  `auto_instruction_content_p` double DEFAULT NULL,
  `auto_information_coverage_p` double DEFAULT NULL,
  `auto_instruction_situation_p` double DEFAULT NULL,
  `integrated_management_cover_p` double DEFAULT NULL,
  `online_purchasing_rate_p` double DEFAULT NULL,
  `min_scheduling_unit_p` double DEFAULT NULL,
  `energy_management_p` double DEFAULT NULL,
  `social_contribution_p` double DEFAULT NULL,
  `business_collaboration_p` double DEFAULT NULL,
  `info_exchange_and_sharing_p` double DEFAULT NULL,
  `value_network_collaboration_p` double DEFAULT NULL,
  `green_development_p` double DEFAULT NULL,
  `maintenance_investment_p` double DEFAULT NULL,
  `organizational_model_p` double DEFAULT NULL,
  `plan_implementation_p` double DEFAULT NULL,
  `material_requirements_p` double DEFAULT NULL,
  `research_development_p` double DEFAULT NULL,
  `business_scope_p` double DEFAULT NULL,
  `equipment_management_p` double DEFAULT NULL,
  `hr_management_p` double DEFAULT NULL,
  `industrial_software_innovation_p` double DEFAULT NULL,
  `output_value_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procindustry`
--

LOCK TABLES `procindustry` WRITE;
/*!40000 ALTER TABLE `procindustry` DISABLE KEYS */;
INSERT INTO `procindustry` VALUES (1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `procindustry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serveindustry`
--

DROP TABLE IF EXISTS `serveindustry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serveindustry` (
  `enterprise_id` int DEFAULT NULL,
  `system_manage_level` double DEFAULT NULL,
  `call_center` double DEFAULT NULL,
  `budget_management` double DEFAULT NULL,
  `service_Integration` double DEFAULT NULL,
  `online_purchase_rate` double DEFAULT NULL,
  `application_scope_of_purchasing_ecommerce` double DEFAULT NULL,
  `labor_productivity` double DEFAULT NULL,
  `Informatization_energy_management` double DEFAULT NULL,
  `Information_exchange_and_sharing` double DEFAULT NULL,
  `maintenance_investment_proportion` double DEFAULT NULL,
  `enterprise_level_unified_coding` double DEFAULT NULL,
  `enterprise_organization_mode` double DEFAULT NULL,
  `informatization_plan_implementation` double DEFAULT NULL,
  `informatization_decision_support` double DEFAULT NULL,
  `informatization_equipment_management` double DEFAULT NULL,
  `informatization_human_resource_management` double DEFAULT NULL,
  `cloud_platform_usage` double DEFAULT NULL,
  `system_manage_level_p` double DEFAULT NULL,
  `call_center_p` double DEFAULT NULL,
  `budget_management_p` double DEFAULT NULL,
  `service_Integration_p` double DEFAULT NULL,
  `online_purchase_rate_p` double DEFAULT NULL,
  `application_scope_of_purchasing_ecommerce_p` double DEFAULT NULL,
  `labor_productivity_p` double DEFAULT NULL,
  `Informatization_energy_management_p` double DEFAULT NULL,
  `Information_exchange_and_sharing_p` double DEFAULT NULL,
  `maintenance_investment_proportion_p` double DEFAULT NULL,
  `enterprise_level_unified_coding_p` double DEFAULT NULL,
  `enterprise_organization_mode_p` double DEFAULT NULL,
  `informatization_plan_implementation_p` double DEFAULT NULL,
  `informatization_decision_support_p` double DEFAULT NULL,
  `informatization_equipment_management_p` double DEFAULT NULL,
  `informatization_human_resource_management_p` double DEFAULT NULL,
  `cloud_platform_usage_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serveindustry`
--

LOCK TABLES `serveindustry` WRITE;
/*!40000 ALTER TABLE `serveindustry` DISABLE KEYS */;
INSERT INTO `serveindustry` VALUES (1,0,0,0,0,11,0,0,0,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `serveindustry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smediscrete`
--

DROP TABLE IF EXISTS `smediscrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smediscrete` (
  `enterprise_id` int DEFAULT NULL,
  `system_manage_level` double DEFAULT NULL,
  `financial_system_monitor_sales` double DEFAULT NULL,
  `auto_instruction_content` double DEFAULT NULL,
  `upload_info_specification` double DEFAULT NULL,
  `info_qua_coverage_area` double DEFAULT NULL,
  `info_qua_function` double DEFAULT NULL,
  `info_monitor_outsourceing` double DEFAULT NULL,
  `info_manage_energy` double DEFAULT NULL,
  `social_contribution_rate` double DEFAULT NULL,
  `info_cooperate_business` double DEFAULT NULL,
  `inter_realize_value_network_synergy` double DEFAULT NULL,
  `online_product_ext_recontrol` double DEFAULT NULL,
  `info_inputmoney_five` double DEFAULT NULL,
  `infosys_rate_info` double DEFAULT NULL,
  `total_assets_proequ` double DEFAULT NULL,
  `enterprise_organization_model` double DEFAULT NULL,
  `info_plan_implement` double DEFAULT NULL,
  `info_matdemand_plan_management` double DEFAULT NULL,
  `info_app_design` double DEFAULT NULL,
  `info_analyze_business_scope` double DEFAULT NULL,
  `info_equ_manage_fun_level` double DEFAULT NULL,
  `info_humanres_fun_level` double DEFAULT NULL,
  `industrysoftware_innovation_ability` double DEFAULT NULL,
  `newproduct_develope_cycle` double DEFAULT NULL,
  `patent_ownership_hundred` double DEFAULT NULL,
  `productmodel_define_data` double DEFAULT NULL,
  `system_manage_level_p` double DEFAULT NULL,
  `financial_system_monitor_sales_p` double DEFAULT NULL,
  `auto_instruction_content_p` double DEFAULT NULL,
  `upload_info_specification_p` double DEFAULT NULL,
  `info_qua_coverage_area_p` double DEFAULT NULL,
  `info_qua_function_p` double DEFAULT NULL,
  `info_monitor_outsourceing_p` double DEFAULT NULL,
  `info_manage_energy_p` double DEFAULT NULL,
  `social_contribution_rate_p` double DEFAULT NULL,
  `info_cooperate_business_p` double DEFAULT NULL,
  `inter_realize_value_network_synergy_p` double DEFAULT NULL,
  `online_product_ext_recontrol_p` double DEFAULT NULL,
  `info_inputmoney_five_p` double DEFAULT NULL,
  `infosys_rate_info_p` double DEFAULT NULL,
  `total_assets_proequ_p` double DEFAULT NULL,
  `enterprise_organization_model_p` double DEFAULT NULL,
  `info_plan_implement_p` double DEFAULT NULL,
  `info_matdemand_plan_management_p` double DEFAULT NULL,
  `info_app_design_p` double DEFAULT NULL,
  `info_analyze_business_scope_p` double DEFAULT NULL,
  `info_equ_manage_fun_level_p` double DEFAULT NULL,
  `info_humanres_fun_level_p` double DEFAULT NULL,
  `industrysoftware_innovation_ability_p` double DEFAULT NULL,
  `newproduct_develope_cycle_p` double DEFAULT NULL,
  `patent_ownership_hundred_p` double DEFAULT NULL,
  `productmodel_define_data_p` double DEFAULT NULL,
  UNIQUE KEY `enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smediscrete`
--

LOCK TABLES `smediscrete` WRITE;
/*!40000 ALTER TABLE `smediscrete` DISABLE KEYS */;
/*!40000 ALTER TABLE `smediscrete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(16) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `usertype` int DEFAULT '0',
  `avatarurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'C1@qq.com','123456','aaaa','123456789',0,'https://huaqi-storage.oss-cn-beijing.aliyuncs.com/storage/fe0fa61797d844a38fcdbbae59bb8165image-20201227152753182.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-02 15:00:32
