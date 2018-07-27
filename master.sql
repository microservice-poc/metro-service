drop   database `metrodb`;
create database `metrodb`;
use metrodb;
source ./metro-train/database/ddl.sql
source ./metro-train/database/dml.sql
