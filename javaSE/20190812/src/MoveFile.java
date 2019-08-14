public interface MoveFile {
    /**
     * 实现对文件的剪切
     * @param origion   原始文件的路径
     * @param dest      目标路径
     * @return true：成功，false：失败
     */
    boolean cut(String origion, String dest) throws Exception;
}
