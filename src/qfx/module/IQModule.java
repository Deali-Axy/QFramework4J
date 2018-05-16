package qfx.module;

import qfx.QComponentVersion;

/*
 * name: IQModule
 * description: QModule接口，所有模块都必须实现该接口
 * date: 1/10/2018 0010 - 0:53
 */
public interface IQModule
{
    String moduleName = "";

    String moduleAuthor = "";

    String moduleMail = "";

    String moduleWebsite = "";

    String moduleDescription = "";

    QComponentVersion moduleVersion = new QComponentVersion();
}
