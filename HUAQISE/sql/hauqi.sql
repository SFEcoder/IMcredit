-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Huaqi
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `User`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `email`       varchar(255) DEFAULT NULL UNIQUE,
    `password`    varchar(16) NOT NULL,
    `username`    varchar(255) DEFAULT NULL,
    `phonenumber` varchar(255) DEFAULT NULL,
    `usertype`    int(2)       DEFAULT 0,
    `avatarurl`   varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

BEGIN;
/*!40000 ALTER TABLE `User`
    DISABLE KEYS */;
INSERT INTO `User`
VALUES (1, 'C1@qq.com', '123456', '客户一号', 123456789, 0,
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c');
/*!40000 ALTER TABLE `User`
    ENABLE KEYS */;
COMMIT;


DROP TABLE IF EXISTS `Enterprise`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Enterprise`
(
    `id`              int(11)      NOT NULL AUTO_INCREMENT,
    `email`           varchar(255) DEFAULT NULL UNIQUE,
    `password`        varchar(16)  NOT NULL,
    `name`            varchar(255) DEFAULT NULL,
    `license`         varchar(255) not NULL,
    `contact_number`  varchar(255) DEFAULT NULL,
    `contact_name`    varchar(255) DEFAULT NULL,
    `register_number` varchar(255) not NULL unique,
    `user_type`       int(2)       default 1,
    `valid`           boolean      Default false,
    `e_photo`         varchar(255) default null,
    `e_grade`         int(4)       default null,
    `financial_score` double,
    `diver_score`     double,
    `total_score`     double,
    `type`            int,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `mixindustry`;
CREATE TABLE `mixindustry`
(
    `enterprise_id`                         int    DEFAULT NULL,
    `system_manage_level`                   double DEFAULT NULL,
    `test_data_rate`                        double DEFAULT NULL,
    `tracking_oforders`                     double DEFAULT NULL,
    `online_purchasing_rate`                double DEFAULT NULL,
    `collection_of_energy_data`             double DEFAULT NULL,
    `auto_instruction_content`              double DEFAULT NULL,
    `monitoring_coverage`                   double DEFAULT NULL,
    `environmental_management`              double DEFAULT NULL,
    `info_exchange_and_sharing`             double DEFAULT NULL,
    `value_network_collaboration`           double DEFAULT NULL,
    `green_development`                     double DEFAULT NULL,
    `social_contribution`                   double DEFAULT NULL,
    `information_investment`                double DEFAULT NULL,
    `equipment_assets`                      double DEFAULT NULL,
    `organizational_model`                  double DEFAULT NULL,
    `informatization_plan_implementation`   double DEFAULT NULL,
    `material_requirements`                 double DEFAULT NULL,
    `business_scope`                        double DEFAULT NULL,
    `equipment_management`                  double DEFAULT NULL,
    `hr_management`                         double DEFAULT NULL,
    `industrial_software_innovation`        double DEFAULT NULL,
    `system_manage_level_p`                 double DEFAULT NULL,
    `test_data_rate_p`                      double DEFAULT NULL,
    `tracking_oforders_p`                   double DEFAULT NULL,
    `online_purchasing_rate_p`              double DEFAULT NULL,
    `collection_of_energy_data_p`           double DEFAULT NULL,
    `auto_instruction_content_p`            double DEFAULT NULL,
    `monitoring_coverage_p`                 double DEFAULT NULL,
    `environmental_management_p`            double DEFAULT NULL,
    `info_exchange_and_sharing_p`           double DEFAULT NULL,
    `value_network_collaboration_p`         double DEFAULT NULL,
    `green_development_p`                   double DEFAULT NULL,
    `social_contribution_p`                 double DEFAULT NULL,
    `information_investment_p`              double DEFAULT NULL,
    `equipment_assets_p`                    double DEFAULT NULL,
    `organizational_model_p`                double DEFAULT NULL,
    `informatization_plan_implementation_p` double DEFAULT NULL,
    `material_requirements_p`               double DEFAULT NULL,
    `business_scope_p`                      double DEFAULT NULL,
    `equipment_management_p`                double DEFAULT NULL,
    `hr_management_p`                       double DEFAULT NULL,
    `industrial_software_innovation_p`      double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `financialindex`;
CREATE TABLE `financialindex`
(
    `enterprise_id`         int    DEFAULT NULL,
    `ttm`                   double DEFAULT NULL,
    `debt_ratio`            double DEFAULT NULL,
    `current_ratio`         double DEFAULT NULL,
    `quick_ratio`           double DEFAULT NULL,
    `cf_cl`                 double DEFAULT NULL,
    `ttal`                  double DEFAULT NULL,
    `operating_revenue`     double DEFAULT NULL,
    `total_profit`          double DEFAULT NULL,
    `total_liabilities`     double DEFAULT NULL,
    `roe`                   double DEFAULT NULL,
    `profit_rate`           double DEFAULT NULL,
    `gross_profit`          double DEFAULT NULL,
    `fe_rev`                double DEFAULT NULL,
    `turnover_days`         double DEFAULT NULL,
    `current_assets`        double DEFAULT NULL,
    `accounts_receivable`   double DEFAULT NULL,
    `ebit_rev`              double DEFAULT NULL,
    `industry_prosperity`   double DEFAULT NULL,
    `ttm_p`                 double DEFAULT NULL,
    `debt_ratio_p`          double DEFAULT NULL,
    `current_ratio_p`       double DEFAULT NULL,
    `quick_ratio_p`         double DEFAULT NULL,
    `cf_cl_p`               double DEFAULT NULL,
    `ttal_p`                double DEFAULT NULL,
    `operating_revenue_p`   double DEFAULT NULL,
    `total_profit_p`        double DEFAULT NULL,
    `total_liabilities_p`   double DEFAULT NULL,
    `roe_p`                 double DEFAULT NULL,
    `profit_rate_p`         double DEFAULT NULL,
    `gross_profit_p`        double DEFAULT NULL,
    `fe_rev_p`              double DEFAULT NULL,
    `turnover_days_p`       double DEFAULT NULL,
    `current_assets_p`      double DEFAULT NULL,
    `accounts_receivable_p` double DEFAULT NULL,
    `ebit_rev_p`            double DEFAULT NULL,
    `industry_prosperity_p` double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `massdiscrete`;
CREATE TABLE `massdiscrete`
(
    `enterprise_id`                 int    DEFAULT NULL,
    `on_time_delivery_rate`         double DEFAULT NULL,
    `system_manage_level`           double DEFAULT NULL,
    `emergency_response`            double DEFAULT NULL,
    `budget_management`             double DEFAULT NULL,
    `auto_instruction_content`      double DEFAULT NULL,
    `environmental_management`      double DEFAULT NULL,
    `energy_management`             double DEFAULT NULL,
    `social_contribution`           double DEFAULT NULL,
    `business_collaboration`        double DEFAULT NULL,
    `value_network_collaboration`   double DEFAULT NULL,
    `tracking_and_feedback`         double DEFAULT NULL,
    `organizational_model`          double DEFAULT NULL,
    `maintenance_investment`        double DEFAULT NULL,
    `plan_implementation`           double DEFAULT NULL,
    `decision_support`              double DEFAULT NULL,
    `equipment_management`          double DEFAULT NULL,
    `hr_management`                 double DEFAULT NULL,
    `on_time_delivery_rate_p`       double DEFAULT NULL,
    `system_manage_level_p`         double DEFAULT NULL,
    `emergency_response_p`          double DEFAULT NULL,
    `budget_management_p`           double DEFAULT NULL,
    `auto_instruction_content_p`    double DEFAULT NULL,
    `environmental_management_p`    double DEFAULT NULL,
    `energy_management_p`           double DEFAULT NULL,
    `social_contribution_p`         double DEFAULT NULL,
    `business_collaboration_p`      double DEFAULT NULL,
    `value_network_collaboration_p` double DEFAULT NULL,
    `tracking_and_feedback_p`       double DEFAULT NULL,
    `organizational_model_p`        double DEFAULT NULL,
    `maintenance_investment_p`      double DEFAULT NULL,
    `plan_implementation_p`         double DEFAULT NULL,
    `decision_support_p`            double DEFAULT NULL,
    `equipment_management_p`        double DEFAULT NULL,
    `hr_management_p`               double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `procindustry`;
CREATE TABLE `procindustry`
(
    `enterprise_id`                    int    DEFAULT NULL,
    `system_manage_level`              double DEFAULT NULL,
    `budget_management`                double DEFAULT NULL,
    `auto_upload_info_range`           double DEFAULT NULL,
    `auto_instruction_content`         double DEFAULT NULL,
    `auto_information_coverage`        double DEFAULT NULL,
    `auto_instruction_situation`       double DEFAULT NULL,
    `integrated_management_cover`      double DEFAULT NULL,
    `online_purchasing_rate`           double DEFAULT NULL,
    `min_scheduling_unit`              double DEFAULT NULL,
    `energy_management`                double DEFAULT NULL,
    `social_contribution`              double DEFAULT NULL,
    `business_collaboration`           double DEFAULT NULL,
    `info_exchange_and_sharing`        double DEFAULT NULL,
    `value_network_collaboration`      double DEFAULT NULL,
    `green_development`                double DEFAULT NULL,
    `maintenance_investment`           double DEFAULT NULL,
    `organizational_model`             double DEFAULT NULL,
    `plan_implementation`              double DEFAULT NULL,
    `material_requirements`            double DEFAULT NULL,
    `research_development`             double DEFAULT NULL,
    `business_scope`                   double DEFAULT NULL,
    `equipment_management`             double DEFAULT NULL,
    `hr_management`                    double DEFAULT NULL,
    `industrial_software_innovation`   double DEFAULT NULL,
    `output_value`                     double DEFAULT NULL,
    `system_manage_level_p`            double DEFAULT NULL,
    `budget_management_p`              double DEFAULT NULL,
    `auto_upload_info_range_p`         double DEFAULT NULL,
    `auto_instruction_content_p`       double DEFAULT NULL,
    `auto_information_coverage_p`      double DEFAULT NULL,
    `auto_instruction_situation_p`     double DEFAULT NULL,
    `integrated_management_cover_p`    double DEFAULT NULL,
    `online_purchasing_rate_p`         double DEFAULT NULL,
    `min_scheduling_unit_p`            double DEFAULT NULL,
    `energy_management_p`              double DEFAULT NULL,
    `social_contribution_p`            double DEFAULT NULL,
    `business_collaboration_p`         double DEFAULT NULL,
    `info_exchange_and_sharing_p`      double DEFAULT NULL,
    `value_network_collaboration_p`    double DEFAULT NULL,
    `green_development_p`              double DEFAULT NULL,
    `maintenance_investment_p`         double DEFAULT NULL,
    `organizational_model_p`           double DEFAULT NULL,
    `plan_implementation_p`            double DEFAULT NULL,
    `material_requirements_p`          double DEFAULT NULL,
    `research_development_p`           double DEFAULT NULL,
    `business_scope_p`                 double DEFAULT NULL,
    `equipment_management_p`           double DEFAULT NULL,
    `hr_management_p`                  double DEFAULT NULL,
    `industrial_software_innovation_p` double DEFAULT NULL,
    `output_value_p`                   double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `serveindustry`;
CREATE TABLE `serveindustry`
(
    `enterprise_id`                               int    DEFAULT NULL,
    `system_manage_level`                         double DEFAULT NULL,
    `call_center`                                 double DEFAULT NULL,
    `budget_management`                           double DEFAULT NULL,
    `service_Integration`                         double DEFAULT NULL,
    `online_purchase_rate`                        double DEFAULT NULL,
    `application_scope_of_purchasing_ecommerce`   double DEFAULT NULL,
    `labor_productivity`                          double DEFAULT NULL,
    `Informatization_energy_management`           double DEFAULT NULL,
    `Information_exchange_and_sharing`            double DEFAULT NULL,
    `maintenance_investment_proportion`           double DEFAULT NULL,
    `enterprise_level_unified_coding`             double DEFAULT NULL,
    `enterprise_organization_mode`                double DEFAULT NULL,
    `informatization_plan_implementation`         double DEFAULT NULL,
    `informatization_decision_support`            double DEFAULT NULL,
    `informatization_equipment_management`        double DEFAULT NULL,
    `informatization_human_resource_management`   double DEFAULT NULL,
    `cloud_platform_usage`                        double DEFAULT NULL,
    `system_manage_level_p`                       double DEFAULT NULL,
    `call_center_p`                               double DEFAULT NULL,
    `budget_management_p`                         double DEFAULT NULL,
    `service_Integration_p`                       double DEFAULT NULL,
    `online_purchase_rate_p`                      double DEFAULT NULL,
    `application_scope_of_purchasing_ecommerce_p` double DEFAULT NULL,
    `labor_productivity_p`                        double DEFAULT NULL,
    `Informatization_energy_management_p`         double DEFAULT NULL,
    `Information_exchange_and_sharing_p`          double DEFAULT NULL,
    `maintenance_investment_proportion_p`         double DEFAULT NULL,
    `enterprise_level_unified_coding_p`           double DEFAULT NULL,
    `enterprise_organization_mode_p`              double DEFAULT NULL,
    `informatization_plan_implementation_p`       double DEFAULT NULL,
    `informatization_decision_support_p`          double DEFAULT NULL,
    `informatization_equipment_management_p`      double DEFAULT NULL,
    `informatization_human_resource_management_p` double DEFAULT NULL,
    `cloud_platform_usage_p`                      double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `smediscrete`;
CREATE TABLE `smediscrete`
(
    `enterprise_id`                         int    DEFAULT NULL,
    `system_manage_level`                   double DEFAULT NULL,
    `financial_system_monitor_sales`        double DEFAULT NULL,
    `auto_instruction_content`              double DEFAULT NULL,
    `upload_info_specification`             double DEFAULT NULL,
    `info_qua_coverage_area`                double DEFAULT NULL,
    `info_qua_function`                     double DEFAULT NULL,
    `info_monitor_outsourceing`             double DEFAULT NULL,
    `info_manage_energy`                    double DEFAULT NULL,
    `social_contribution_rate`              double DEFAULT NULL,
    `info_cooperate_business`               double DEFAULT NULL,
    `inter_realize_value_network_synergy`   double DEFAULT NULL,
    `online_product_ext_recontrol`          double DEFAULT NULL,
    `info_inputmoney_five`                  double DEFAULT NULL,
    `infosys_rate_info`                     double DEFAULT NULL,
    `total_assets_proequ`                   double DEFAULT NULL,
    `enterprise_organization_model`         double DEFAULT NULL,
    `info_plan_implement`                   double DEFAULT NULL,
    `info_matdemand_plan_management`        double DEFAULT NULL,
    `info_app_design`                       double DEFAULT NULL,
    `info_analyze_business_scope`           double DEFAULT NULL,
    `info_equ_manage_fun_level`             double DEFAULT NULL,
    `info_humanres_fun_level`               double DEFAULT NULL,
    `industrysoftware_innovation_ability`   double DEFAULT NULL,
    `newproduct_develope_cycle`             double DEFAULT NULL,
    `patent_ownership_hundred`              double DEFAULT NULL,
    `productmodel_define_data`              double DEFAULT NULL,
    `system_manage_level_p`                 double DEFAULT NULL,
    `financial_system_monitor_sales_p`      double DEFAULT NULL,
    `auto_instruction_content_p`            double DEFAULT NULL,
    `upload_info_specification_p`           double DEFAULT NULL,
    `info_qua_coverage_area_p`              double DEFAULT NULL,
    `info_qua_function_p`                   double DEFAULT NULL,
    `info_monitor_outsourceing_p`           double DEFAULT NULL,
    `info_manage_energy_p`                  double DEFAULT NULL,
    `social_contribution_rate_p`            double DEFAULT NULL,
    `info_cooperate_business_p`             double DEFAULT NULL,
    `inter_realize_value_network_synergy_p` double DEFAULT NULL,
    `online_product_ext_recontrol_p`        double DEFAULT NULL,
    `info_inputmoney_five_p`                double DEFAULT NULL,
    `infosys_rate_info_p`                   double DEFAULT NULL,
    `total_assets_proequ_p`                 double DEFAULT NULL,
    `enterprise_organization_model_p`       double DEFAULT NULL,
    `info_plan_implement_p`                 double DEFAULT NULL,
    `info_matdemand_plan_management_p`      double DEFAULT NULL,
    `info_app_design_p`                     double DEFAULT NULL,
    `info_analyze_business_scope_p`         double DEFAULT NULL,
    `info_equ_manage_fun_level_p`           double DEFAULT NULL,
    `info_humanres_fun_level_p`             double DEFAULT NULL,
    `industrysoftware_innovation_ability_p` double DEFAULT NULL,
    `newproduct_develope_cycle_p`           double DEFAULT NULL,
    `patent_ownership_hundred_p`            double DEFAULT NULL,
    `productmodel_define_data_p`            double DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
--
-- Dumping data for table `User`
--

BEGIN;
/*!40000 ALTER TABLE `Enterprise`
    DISABLE KEYS */;
INSERT INTO `Enterprise`
VALUES (1, '123@qq.com', '123456', '企业一号',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', '12345678', 'assd',
        '1234553223', 1, false,
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', null, null, null, 1);
INSERT INTO `Enterprise`
VALUES (2, '223@qq.com', '123456', '企业二号',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', '12345678', 'assd',
        '2234553223', 1, false,
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', null, null, null, 1);
INSERT INTO `Enterprise`
VALUES (3, '323@qq.com', '123456', '企业三号',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', '12345678', 'assd',
        '3234553223', 1, false,
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', null, null, null, 1);
INSERT INTO `Enterprise`
VALUES (4, '423@qq.com', '123456', '企业四号',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', '12345678', 'assd',
        '4234553223', 1, false,
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c',
        'https://pic4.zhimg.com/80/v2-00196e71224b2e48ea7a2223a50f2bdd_1440w.jpg?source=1940ef5c', null, null, null, 1);
/*!40000 ALTER TABLE `Enterprise`
    ENABLE KEYS */;
COMMIT;

BEGIN;
/*!40000 ALTER TABLE `financialindex`
    DISABLE KEYS */;
TRUNCATE TABLE financialindex;
# INSERT INTO `financialindex` VALUES (1,4.0,0.52,2.0,2.5,0.5,2.0,0.05,0.5,1.0,1.0,0.3,0.1,0.5,166.0,2.0,3.0,55.0,1.0);
INSERT INTO `financialindex`
VALUES (2, 3.0, 0.51, 2.0, 2.5, 0.5, 2.0, 0.05, 0.5, 1.0, 1.0, 0.3, 0.1, 0.5, 166.0, 2.0, 3.0, 55.0, 1.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
INSERT INTO `financialindex`
VALUES (3, 2.0, 0.5, 2.0, 2.5, 0.5, 2.0, 0.05, 0.5, 1.0, 1.0, 0.3, 0.1, 0.6, 111.0, 2.0, 4.0, 55.0, 1.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
INSERT INTO `financialindex`
VALUES (4, 5.0, 0.5, 2.0, 2.5, 0.5, 2.0, 0.05, 0.5, 1.0, 1.0, 0.3, 0.1, 0.2, 222.0, 2.0, 5.0, 5.0, 1.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
/*!40000 ALTER TABLE `financialindex`
    ENABLE KEYS */;
COMMIT;

BEGIN;
/*!40000 ALTER TABLE `massdiscrete`
    DISABLE KEYS */;
TRUNCATE TABLE massdiscrete;
# INSERT INTO `massdiscrete` VALUES (1,95.0,3.0,1.0,-2.0,1.0,0.0,1.0,30.92,2.0,1.0,1.0,8.0,2.0,1.0,2.0,3.0,2.0);
INSERT INTO `massdiscrete`
VALUES (2, 100.0, 4.0, 2.0, -5.0, 5.0, 3.0, 3.0, 39.43, 9.0, 1.0, 5.0, 65.0, 3.0, 1.0, 4.0, 4.0, 4.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
INSERT INTO `massdiscrete`
VALUES (3, 100.0, 0.0, 1.0, 0.0, -1.0, 0.0, 0.0, 20.0, 0.0, 1.0, 1.0, 40.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
INSERT INTO `massdiscrete`
VALUES (4, 99.0, 4.0, 2.0, -3.0, -5.0, 0.0, 0.0, 43.0, 2.0, 0.0, 2.0, 42.0, 0.0, 1.0, 0.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
/*!40000 ALTER TABLE `massdiscrete`
    ENABLE KEYS */;
COMMIT;

DROP TABLE IF EXISTS `Browse`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Browse`
(
    `user_id`     int(11)     NOT NULL,
    `ep_id`       int(11)     NOT NULL,
    `create_time` varchar(20) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2020-04-12 10:08:42
SET FOREIGN_KEY_CHECKS = 1;
