package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.rompos.activator.kmm.androidApp.DataBinderMapperImpl());
  }
}
