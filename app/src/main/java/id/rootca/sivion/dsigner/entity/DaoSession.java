package id.rootca.sivion.dsigner.entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import id.rootca.sivion.dsigner.entity.FileInfo;
import id.rootca.sivion.dsigner.entity.Document;
import id.rootca.sivion.dsigner.entity.SignedDocument;

import id.rootca.sivion.dsigner.entity.FileInfoDao;
import id.rootca.sivion.dsigner.entity.DocumentDao;
import id.rootca.sivion.dsigner.entity.SignedDocumentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig fileInfoDaoConfig;
    private final DaoConfig documentDaoConfig;
    private final DaoConfig signedDocumentDaoConfig;

    private final FileInfoDao fileInfoDao;
    private final DocumentDao documentDao;
    private final SignedDocumentDao signedDocumentDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        fileInfoDaoConfig = daoConfigMap.get(FileInfoDao.class).clone();
        fileInfoDaoConfig.initIdentityScope(type);

        documentDaoConfig = daoConfigMap.get(DocumentDao.class).clone();
        documentDaoConfig.initIdentityScope(type);

        signedDocumentDaoConfig = daoConfigMap.get(SignedDocumentDao.class).clone();
        signedDocumentDaoConfig.initIdentityScope(type);

        fileInfoDao = new FileInfoDao(fileInfoDaoConfig, this);
        documentDao = new DocumentDao(documentDaoConfig, this);
        signedDocumentDao = new SignedDocumentDao(signedDocumentDaoConfig, this);

        registerDao(FileInfo.class, fileInfoDao);
        registerDao(Document.class, documentDao);
        registerDao(SignedDocument.class, signedDocumentDao);
    }
    
    public void clear() {
        fileInfoDaoConfig.getIdentityScope().clear();
        documentDaoConfig.getIdentityScope().clear();
        signedDocumentDaoConfig.getIdentityScope().clear();
    }

    public FileInfoDao getFileInfoDao() {
        return fileInfoDao;
    }

    public DocumentDao getDocumentDao() {
        return documentDao;
    }

    public SignedDocumentDao getSignedDocumentDao() {
        return signedDocumentDao;
    }

}
