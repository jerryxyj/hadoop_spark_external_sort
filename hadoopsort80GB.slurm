#!/bin/sh
##SBATCH --partition=compute
##SBATCH --job-name=hadoopsort
#SBATCH --nodes=1
##SBATCH --ntasks=1
##SBATCH --time=0:20:00
##SBATCH --wait-all-node=1
#SBATCH --output=hadoopsort80GB.log

START_TIME=$SECONDS
hadoop jar HadoopSort.jar HadoopSort /input/data-80GB/ /user/yxu81/output-hadoop -D mapred.reduce.tasks=1
##ELAPSED_TIME=$(($SECONDS-$START_TIME))
##echo "$ELAPSED_TIME"
hadoop jar /opt/hadoop-2.9.0/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.9.0.jar teravalidate /user/yxu81/output-hadoop /user/yxu81/report-hadoop
hadoop fs -get /user/yxu81/report-hadoop/part-r-00000

