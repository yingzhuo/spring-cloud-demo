usage:
	@echo "========================================================================================="
	@echo "usage (default)      : 显示本菜单"
	@echo "wrapper              : 初始化GradleWrapper"
	@echo "clean                : 清理项目"
	@echo "compile              : 编译项目"
	@echo "build-jar            : 构建项目 (通用)"
	@echo "github               : 推送文件到Github"
	@echo "========================================================================================="

wrapper:
	@gradle wrapper --gradle-distribution-url 'https://mirrors.cloud.tencent.com/gradle/gradle-8.12.1-bin.zip'

clean:
	@gradlew clean -q

compile:
	@gradlew classes

build-jar:
	@gradlew build -x"test"

github: clean
	@git status
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage wrapper clean compile build-jar github