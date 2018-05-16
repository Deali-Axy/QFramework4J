package qfx.diagnostics;

/**
 * name: QDebugLevel
 * description:
 * date: 1/12/2018 0012 - 1:46
 */
public enum QDebugLevel
{
    /**
     * description: 调试信息，很细粒度的日志信息。比如，某一个变量值。
    */
    DEBUG,
    
    /**
     * description: 一些提示性质的信息，比如系统启动过程中的一些信息，表明某一个模块正常启动。
    */
    INFO,
    
    /**
     * description: 警告性质的信息，可能会有问题，但是一般情况下，应该不会引起错误。
    */
    WARN,

    /**
     * description: 错误信息。对于定位问题，最重要的一种日志信息，一般会有异常堆栈信息。
    */
    ERROR,

    /**
     * description: 最高级别的错误信息
    */
    FATAL,
}
